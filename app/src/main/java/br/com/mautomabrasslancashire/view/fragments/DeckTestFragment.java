package br.com.mautomabrasslancashire.view.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import br.com.mautomabrasslancashire.R;
import br.com.mautomabrasslancashire.domain.bus.DataOut;
import br.com.mautomabrasslancashire.domain.entities.Card;
import br.com.mautomabrasslancashire.view.viewmodel.LoadDeckViewModel;

public class DeckTestFragment extends Fragment implements DataOut.Callback<List<Card>> {

    private ImageView iv;
    private LoadDeckViewModel viewModel;
    private int currentDeckIndex;
    private List<Card> cards, deckA, deckB, deckC, gameDeck;
    private Card currentCard;


    public DeckTestFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        currentDeckIndex = 0;
    }

    @Override
    public void onResume() {
        super.onResume();
        viewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity()
        .getApplication()).create(LoadDeckViewModel.class);

        loadDeck();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_deck_test, container, false);
        ((Button)view.findViewById(R.id.bt_back)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentDeckIndex > 0){
                    currentCard = gameDeck.get(currentDeckIndex-1);
                    iv.setImageDrawable(currentCard.getDrawable());
                    currentDeckIndex-=1;
                }
            }
        });

        ((Button)view.findViewById(R.id.bt_flip)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for(Card card : cards){
                    if(currentCard.isFront()){
                        if(currentCard.getName().equalsIgnoreCase(card.getName())
                        && !card.isFront()){
                            currentCard = card;
                            iv.setImageDrawable(currentCard.getDrawable());
                            break;
                        }
                    }else{
                        if(currentCard.getName().equalsIgnoreCase(card.getName())
                                && card.isFront()){
                            currentCard = card;
                            iv.setImageDrawable(currentCard.getDrawable());
                            break;
                        }
                    }
                }
            }
        });

        ((Button)view.findViewById(R.id.bt_next)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentDeckIndex < gameDeck.size()-1){
                    currentCard = gameDeck.get(currentDeckIndex+1);
                    iv.setImageDrawable(currentCard.getDrawable());
                    currentDeckIndex+=1;
                }
            }
        });

        iv =(ImageView)view.findViewById(R.id.iv_test);

        return view;
    }

    private void loadDeck(){
        viewModel.loadDeck(this);
    }

    @Override
    public void onSuccess(List<Card> parameter) {
        if(parameter != null){
            cards = parameter;
            splitAndShuffle();
        }
    }

    @Override
    public void onError(Throwable throwable) {

    }

    public void splitAndShuffle(){

        deckA = new ArrayList<Card>();
        deckB = new ArrayList<Card>();
        deckC = new ArrayList<Card>();
        gameDeck = new ArrayList<Card>();

        for(Card card : cards){
            if(card.getName().startsWith("a") && card.isFront())
                deckA.add(card);
            else if(card.getName().startsWith("b") && card.isFront())
                deckB.add(card);
            else if(card.getName().startsWith("c") && card.isFront())
                deckC.add(card);
        }

        gameDeck = deckA;
        currentCard = gameDeck.get(currentDeckIndex);
        iv.setImageDrawable(currentCard.getDrawable());
    }
}