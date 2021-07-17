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
    private List<Card>deckA, deckB, deckC;

    public LoadDeckRepositoryImpl(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public void loadDeckCards(DataOut.Callback callback) {
        try{
            Resources res = mContext.getResources();

            deckA = new ArrayList<Card>();

            Drawable a21b = ResourcesCompat.getDrawable(res, R.drawable.a21b, null);
            Drawable a21f = ResourcesCompat.getDrawable(res, R.drawable.a21f, null);
            Drawable a22b = ResourcesCompat.getDrawable(res, R.drawable.a22b_cl, null);
            Drawable a22f = ResourcesCompat.getDrawable(res, R.drawable.a22f_cl, null);
            Drawable a23b = ResourcesCompat.getDrawable(res, R.drawable.a23b_cl, null);
            Drawable a23f = ResourcesCompat.getDrawable(res, R.drawable.a23f_cl, null);
//            Drawable a24b = ResourcesCompat.getDrawable(res, R.drawable.a24b_cm, null);
//            Drawable a24f = ResourcesCompat.getDrawable(res, R.drawable.a24f_cm, null);
//            Drawable a25b = ResourcesCompat.getDrawable(res, R.drawable.a25b_cm, null);
//            Drawable a25f = ResourcesCompat.getDrawable(res, R.drawable.a25f_cm, null);
            Drawable a26b = ResourcesCompat.getDrawable(res, R.drawable.a26b_cl, null);
            Drawable a26f = ResourcesCompat.getDrawable(res, R.drawable.a26f_cl, null);
//            Drawable a27b = ResourcesCompat.getDrawable(res, R.drawable.a27b_, null);
//            Drawable a27f = ResourcesCompat.getDrawable(res, R.drawable.a27f_, null);
            Drawable a28b = ResourcesCompat.getDrawable(res, R.drawable.a28b, null);
            Drawable a28f = ResourcesCompat.getDrawable(res, R.drawable.a28f, null);
//            Drawable a29b = ResourcesCompat.getDrawable(res, R.drawable.a29b_cm, null);
//            Drawable a29f = ResourcesCompat.getDrawable(res, R.drawable.a29f_cm, null);
            Drawable a30b = ResourcesCompat.getDrawable(res, R.drawable.a30b, null);
            Drawable a30f = ResourcesCompat.getDrawable(res, R.drawable.a30f, null);
            Drawable a41b = ResourcesCompat.getDrawable(res, R.drawable.a41b_cl, null);
            Drawable a41f = ResourcesCompat.getDrawable(res, R.drawable.a41f_cl, null);
//            Drawable a5b = ResourcesCompat.getDrawable(res, R.drawable.a5b_cm, null);
//            Drawable a5f = ResourcesCompat.getDrawable(res, R.drawable.a5f_cm, null);
            Drawable a6b = ResourcesCompat.getDrawable(res, R.drawable.a6b_cl, null);
            Drawable a6f = ResourcesCompat.getDrawable(res, R.drawable.a6f_cl, null);
            Drawable a8b = ResourcesCompat.getDrawable(res, R.drawable.a8b, null);
            Drawable a8f = ResourcesCompat.getDrawable(res, R.drawable.a8f, null);
            Drawable a9b = ResourcesCompat.getDrawable(res, R.drawable.a9b, null);
            Drawable a9f = ResourcesCompat.getDrawable(res, R.drawable.a9f, null);

            Drawable b13b = ResourcesCompat.getDrawable(res, R.drawable.b13b, null);
            Drawable b13f = ResourcesCompat.getDrawable(res, R.drawable.b13f, null);
            Drawable b14b = ResourcesCompat.getDrawable(res, R.drawable.b14b_cl, null);
            Drawable b14f = ResourcesCompat.getDrawable(res, R.drawable.b14f_cl, null);
            Drawable b15b = ResourcesCompat.getDrawable(res, R.drawable.b15b, null);
            Drawable b15f = ResourcesCompat.getDrawable(res, R.drawable.b15f, null);
            Drawable b31b = ResourcesCompat.getDrawable(res, R.drawable.b31b, null);
            Drawable b31f = ResourcesCompat.getDrawable(res, R.drawable.b31f, null);
//            Drawable b32b = ResourcesCompat.getDrawable(res, R.drawable.b32b_cm, null);
//            Drawable b32f = ResourcesCompat.getDrawable(res, R.drawable.b32f_cm, null);
//            Drawable b33b = ResourcesCompat.getDrawable(res, R.drawable.b33b_cm, null);
//            Drawable b33f = ResourcesCompat.getDrawable(res, R.drawable.b33f__cm, null);
            Drawable b34b = ResourcesCompat.getDrawable(res, R.drawable.b34b, null);
            Drawable b34f = ResourcesCompat.getDrawable(res, R.drawable.b34f, null);
            Drawable b36b = ResourcesCompat.getDrawable(res, R.drawable.b36b_cl, null);
            Drawable b36f = ResourcesCompat.getDrawable(res, R.drawable.b36f_cl, null);
            Drawable b37b = ResourcesCompat.getDrawable(res, R.drawable.b37b, null);
            Drawable b37f = ResourcesCompat.getDrawable(res, R.drawable.b37f, null);
            Drawable b39b = ResourcesCompat.getDrawable(res, R.drawable.b39b_cl, null);
            Drawable b39f = ResourcesCompat.getDrawable(res, R.drawable.b39f_cl, null);

            Drawable c10b = ResourcesCompat.getDrawable(res, R.drawable.c10b_cl, null);
            Drawable c10f = ResourcesCompat.getDrawable(res, R.drawable.c10f_cl, null);
//            Drawable c11b = ResourcesCompat.getDrawable(res, R.drawable.c11b_cm, null);
//            Drawable c11f = ResourcesCompat.getDrawable(res, R.drawable.c11f_cm, null);
            Drawable c12b = ResourcesCompat.getDrawable(res, R.drawable.c12b, null);
            Drawable c12f = ResourcesCompat.getDrawable(res, R.drawable.c12f, null);
            Drawable c16b = ResourcesCompat.getDrawable(res, R.drawable.c16b, null);
            Drawable c16f = ResourcesCompat.getDrawable(res, R.drawable.c16f, null);
//            Drawable c17b = ResourcesCompat.getDrawable(res, R.drawable.c17b_cm, null);
//            Drawable c17f = ResourcesCompat.getDrawable(res, R.drawable.c17f_cm, null);
            Drawable c18b = ResourcesCompat.getDrawable(res, R.drawable.c18b, null);
            Drawable c18f = ResourcesCompat.getDrawable(res, R.drawable.c18f, null);
            Drawable c19b = ResourcesCompat.getDrawable(res, R.drawable.c19b_cl, null);
            Drawable c19f = ResourcesCompat.getDrawable(res, R.drawable.c19f_cl, null);
            Drawable c1b = ResourcesCompat.getDrawable(res, R.drawable.c1b_cl, null);
            Drawable c1f = ResourcesCompat.getDrawable(res, R.drawable.c1f_cl, null);
//            Drawable c20b = ResourcesCompat.getDrawable(res, R.drawable.c20b_cm, null);
//            Drawable c20f = ResourcesCompat.getDrawable(res, R.drawable.c20f_cm, null);
            Drawable c2b = ResourcesCompat.getDrawable(res, R.drawable.c2b, null);
            Drawable c2f = ResourcesCompat.getDrawable(res, R.drawable.c2f, null);
            Drawable c35b = ResourcesCompat.getDrawable(res, R.drawable.c35b, null);
            Drawable c35f = ResourcesCompat.getDrawable(res, R.drawable.c35f, null);
            Drawable c38b = ResourcesCompat.getDrawable(res, R.drawable.c38b_cl, null);
            Drawable c38f = ResourcesCompat.getDrawable(res, R.drawable.c38f_cl, null);
            Drawable c3b = ResourcesCompat.getDrawable(res, R.drawable.c3b, null);
            Drawable c3f = ResourcesCompat.getDrawable(res, R.drawable.c3f, null);
            Drawable c40b = ResourcesCompat.getDrawable(res, R.drawable.c40b_cl, null);
            Drawable c40f = ResourcesCompat.getDrawable(res, R.drawable.c40f_cl, null);
            Drawable c42b = ResourcesCompat.getDrawable(res, R.drawable.c42b, null);
            Drawable c42f = ResourcesCompat.getDrawable(res, R.drawable.c42f, null);
            Drawable c4b = ResourcesCompat.getDrawable(res, R.drawable.c4b, null);
            Drawable c4f = ResourcesCompat.getDrawable(res, R.drawable.c4f, null);
            Drawable c7b = ResourcesCompat.getDrawable(res, R.drawable.c7b_cl, null);
            Drawable c7f = ResourcesCompat.getDrawable(res, R.drawable.c7f_cl, null);


            List<Card> cards = new ArrayList<Card>();
            cards.add(new Card("a21b", false, true, false, a21b));
            cards.add(new Card("a21f", false, true, false, a21f));
            cards.add(new Card("a22b", false, true, false, a22b));
            cards.add(new Card("a22f", false, true, false, a22f));
            cards.add(new Card("a23b", false, true, false, a23b));
            cards.add(new Card("a23f", false, true, false, a23f));
            cards.add(new Card("a26b", false, true, false, a26b));
            cards.add(new Card("a26f", false, true, false, a26f));
            cards.add(new Card("a28b", false, true, false, a28b));
            cards.add(new Card("a28f", false, true, false, a28f));
            cards.add(new Card("a30b", false, true, false, a30b));
            cards.add(new Card("a30f", false, true, false, a30f));
            cards.add(new Card("a41b", false, true, false, a41b));
            cards.add(new Card("a41f", false, true, false, a41f));
            cards.add(new Card("a6b", false, true, false, a6b));
            cards.add(new Card("a6f", false, true, false, a6f));
            cards.add(new Card("a8b", false, true, false, a8b));
            cards.add(new Card("a8f", false, true, false, a8f));
            cards.add(new Card("a9b", false, true, false, a9b));
            cards.add(new Card("a9f", false, true, false, a9f));
            cards.add(new Card("b13b", false, true, false, b13b));
            cards.add(new Card("b13f", false, true, false, b13f));
            cards.add(new Card("b14b", false, true, false, b14b));
            cards.add(new Card("b14f", false, true, false, b14f));
            cards.add(new Card("b15b", false, true, false, b15b));
            cards.add(new Card("b15f", false, true, false, b15f));
            cards.add(new Card("b31b", false, true, false, b31b));
            cards.add(new Card("b31f", false, true, false, b31f));
            cards.add(new Card("b34b", false, true, false, b34b));
            cards.add(new Card("b34f", false, true, false, b34f));
            cards.add(new Card("b36b", false, true, false, b36b));
            cards.add(new Card("b36f", false, true, false, b36f));
            cards.add(new Card("b37b", false, true, false, b37b));
            cards.add(new Card("b37f", false, true, false, b37f));
            cards.add(new Card("b39b", false, true, false, b39b));
            cards.add(new Card("b39f", false, true, false, b39f));
            cards.add(new Card("c10b", false, true, false, c10b));
            cards.add(new Card("c10f", false, true, false, c10f));
            cards.add(new Card("c12b", false, true, false, c12b));
            cards.add(new Card("c12f", false, true, false, c12f));
            cards.add(new Card("c16b", false, true, false, c16b));
            cards.add(new Card("c16f", false, true, false, c16f));
            cards.add(new Card("c18b", false, true, false, c18b));
            cards.add(new Card("c18f", false, true, false, c18f));
            cards.add(new Card("c19b", false, true, false, c19b));
            cards.add(new Card("c19f", false, true, false, c19f));
            cards.add(new Card("c1b", false, true, false, c1b));
            cards.add(new Card("c1f", false, true, false, c1f));
            cards.add(new Card("c2b", false, true, false, c2b));
            cards.add(new Card("c2f", false, true, false, c2f));
            cards.add(new Card("c35b", false, true, false, c35b));
            cards.add(new Card("c35f", false, true, false, c35f));
            cards.add(new Card("c38b", false, true, false, c38b));
            cards.add(new Card("c38f", false, true, false, c38f));
            cards.add(new Card("c3b", false, true, false, c3b));
            cards.add(new Card("c3f", false, true, false, c3f));
            cards.add(new Card("c40b", false, true, false, c40b));
            cards.add(new Card("c40f", false, true, false, c40f));
            cards.add(new Card("c42b", false, true, false, c42b));
            cards.add(new Card("c42f", false, true, false, c42f));
            cards.add(new Card("c4b", false, true, false, c4b));
            cards.add(new Card("c4f", false, true, false, c4f));
            cards.add(new Card("c7b", false, true, false, c7b));
            cards.add(new Card("c7f", false, true, false, c7f));

            callback.onSuccess(cards);
        }catch (Exception e){
            callback.onError(e);
        }
    }
}
