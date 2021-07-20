package br.com.mautomabrasslancashire.view.bus;

import androidx.lifecycle.LiveData;

import java.util.List;

import br.com.mautomabrasslancashire.domain.bus.DataOut;
import br.com.mautomabrasslancashire.domain.entities.Card;

public interface LoadDeckView extends DataOut.Callback<List<Card>> {
    void loadDeck(DataOut.Callback<LiveData<List<Card>>> callback);
}
