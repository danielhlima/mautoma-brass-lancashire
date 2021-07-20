package br.com.mautomabrasslancashire.view.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import br.com.mautomabrasslancashire.domain.bus.DataOut;
import br.com.mautomabrasslancashire.domain.entities.Card;
import br.com.mautomabrasslancashire.presenter.LoadDeckPresenter;
import br.com.mautomabrasslancashire.view.bus.LoadDeckView;

public class LoadDeckViewModel extends AndroidViewModel implements LoadDeckView {

    private LoadDeckPresenter presenter;
    private DataOut.Callback<LiveData<List<Card>>> callback;
    private MutableLiveData<List<Card>> cards;

    public LoadDeckViewModel(@NonNull Application application) {
        super(application);
        presenter = new LoadDeckPresenter(application.getApplicationContext(), this);
    }

    @Override
    public void loadDeck(DataOut.Callback<LiveData<List<Card>>> callback) {
        this.callback = callback;
        presenter.loadDeck();
    }

    @Override
    public void onSuccess(List<Card> parameter) {
        if(cards == null){
            cards = new MutableLiveData<List<Card>>();
            cards.setValue(parameter);
        }
        callback.onSuccess(cards);
    }

    @Override
    public void onError(Throwable throwable) {
        callback.onError(throwable);
    }
}
