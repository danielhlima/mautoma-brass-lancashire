package br.com.mautomabrasslancashire.domain.repositories;

import br.com.mautomabrasslancashire.domain.bus.DataOut;

public interface LoadDeckRepository {

    void loadDeckCards(DataOut.Callback callback);
    void loadDeckCardsForCommunityVersion(DataOut.Callback callback);
}
