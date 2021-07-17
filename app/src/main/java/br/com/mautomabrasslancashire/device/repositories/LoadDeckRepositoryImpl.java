package br.com.mautomabrasslancashire.device.repositories;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import androidx.core.content.res.ResourcesCompat;

import java.util.ArrayList;
import java.util.List;

import br.com.mautomabrasslancashire.R;
import br.com.mautomabrasslancashire.domain.bus.DataOut;
import br.com.mautomabrasslancashire.domain.entities.Card;
import br.com.mautomabrasslancashire.domain.repositories.LoadDeckRepository;

public class LoadDeckRepositoryImpl implements LoadDeckRepository {

    private Context mContext;

    public LoadDeckRepositoryImpl(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public void loadDeckCards(DataOut.Callback callback) {
        try{
            Resources res = mContext.getResources();
            Drawable a21b = ResourcesCompat.getDrawable(res, R.drawable.a21f, null);
            List<Card> cards = new ArrayList<Card>();
            cards.add(new Card("a21a", false, true, false, a21b));
            callback.onSuccess(cards);
        }catch (Exception e){
            callback.onError(e);
        }
    }
}
