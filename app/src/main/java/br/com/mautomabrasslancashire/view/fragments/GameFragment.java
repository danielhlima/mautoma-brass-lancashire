package br.com.mautomabrasslancashire.view.fragments;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.mautomabrasslancashire.R;
import br.com.mautomabrasslancashire.domain.bus.DataOut;
import br.com.mautomabrasslancashire.domain.entities.Card;
import br.com.mautomabrasslancashire.view.viewmodel.LoadDeckViewModel;

public class GameFragment extends Fragment implements DataOut.Callback<List<Card>> {

    private ImageView iv;
    private LoadDeckViewModel viewModel;
    private int currentDeckIndex;
    private List<Card> cards, deckA, deckB, deckC, gameDeck;
    private Card currentCard;
    private boolean firstDraw;
    private MediaPlayer player;


    public GameFragment() {
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
        firstDraw = true;
        loadDeck();
        player = MediaPlayer.create(getContext(), R.raw.cardflip);
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
                    currentDeckIndex-=1;
                    currentCard = gameDeck.get(currentDeckIndex);
                    player.start();

                    final Drawable drawable=currentCard.getDrawable();
                    final ImageView iv_ = iv;
                    iv_.setRotationY(0f);
                    iv_.animate().rotationY(90f).setListener(new AnimatorListenerAdapter()
                    {
                        @Override
                        public void onAnimationEnd(Animator animation)
                        {
                            iv_.setImageDrawable(drawable);
                            iv_.setRotationY(270f);
                            iv_.animate().rotationY(360f).setListener(null);
                        }
                    });
                }
            }
        });

        ((Button)view.findViewById(R.id.bt_flip)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flipCard();
            }
        });

        ((Button)view.findViewById(R.id.bt_top)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentDeckIndex + 1 == gameDeck.size()){
                    Collections.shuffle(gameDeck);
                    currentDeckIndex = 0;
                    currentCard = gameDeck.get(currentDeckIndex);
                }

                Card topCard = gameDeck.get(currentDeckIndex+1);

                for(Card card : cards){
                    if(topCard.getName().equalsIgnoreCase(card.getName())
                            && !card.isFront()){

                        final Drawable drawable=card.getDrawable();
                        final ImageView iv_ = iv;
                        iv_.setRotationY(0f);
                        iv_.animate().rotationY(90f).setListener(new AnimatorListenerAdapter()
                        {
                            @Override
                            public void onAnimationEnd(Animator animation)
                            {
                                iv_.setImageDrawable(drawable);
                                iv_.setRotationY(270f);
                                iv_.animate().rotationY(360f).setListener(null);
                            }
                        });
                        break;
                    }
                }
                ((Button)view.findViewById(R.id.bt_top)).setVisibility(View.INVISIBLE);
                ((Button)view.findViewById(R.id.bt_back)).setVisibility(View.INVISIBLE);
                ((Button)view.findViewById(R.id.bt_flip)).setVisibility(View.INVISIBLE);
                player.start();
            }
        });

        ((Button)view.findViewById(R.id.bt_next)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(firstDraw){
                    flipCard();
                    firstDraw = false;
                }else{
                    if (currentDeckIndex < gameDeck.size()-1){
                        currentDeckIndex+=1;
                        currentCard = gameDeck.get(currentDeckIndex);
                        final Drawable drawable=currentCard.getDrawable();
                        final ImageView iv_ = iv;
                        iv_.setRotationY(0f);
                        iv_.animate().rotationY(90f).setListener(new AnimatorListenerAdapter()
                        {
                            @Override
                            public void onAnimationEnd(Animator animation)
                            {
                                iv_.setImageDrawable(drawable);
                                iv_.setRotationY(270f);
                                iv_.animate().rotationY(360f).setListener(null);
                            }
                        });
                    }else{
                        Collections.shuffle(gameDeck);
                        currentDeckIndex = 0;
                        currentCard = gameDeck.get(currentDeckIndex);
                        final Drawable drawable=currentCard.getDrawable();
                        final ImageView iv_ = iv;
                        iv_.setRotationY(0f);
                        iv_.animate().rotationY(90f).setListener(new AnimatorListenerAdapter()
                        {
                            @Override
                            public void onAnimationEnd(Animator animation)
                            {
                                iv_.setImageDrawable(drawable);
                                iv_.setRotationY(270f);
                                iv_.animate().rotationY(360f).setListener(null);
                            }
                        });
                    }
                }
                ((Button)view.findViewById(R.id.bt_top)).setVisibility(View.VISIBLE);
                ((Button)view.findViewById(R.id.bt_flip)).setVisibility(View.VISIBLE);
                ((Button)view.findViewById(R.id.bt_back)).setVisibility(View.VISIBLE);
                player.start();
            }
        });

        ((Button)view.findViewById(R.id.bt_canal)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Button)view.findViewById(R.id.bt_top)).setVisibility(View.INVISIBLE);
                ((Button)view.findViewById(R.id.bt_flip)).setVisibility(View.VISIBLE);
                ((Button)view.findViewById(R.id.bt_back)).setVisibility(View.VISIBLE);
                firstDraw = true;
                splitAndShuffle(false);
                player.start();
            }
        });

        ((Button)view.findViewById(R.id.bt_rail)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Button)view.findViewById(R.id.bt_top)).setVisibility(View.VISIBLE);
                ((Button)view.findViewById(R.id.bt_flip)).setVisibility(View.VISIBLE);
                ((Button)view.findViewById(R.id.bt_back)).setVisibility(View.VISIBLE);
                splitAndShuffle(true);
                player.start();
            }
        });

        iv =(ImageView)view.findViewById(R.id.iv_test);

        return view;
    }

    private void flipCard(){
        player.start();
        for(Card card : cards){
            if(currentCard.isFront()){
                if(currentCard.getName().equalsIgnoreCase(card.getName())
                        && !card.isFront()){
                    currentCard = card;
                    break;
                }
            }else{
                if(currentCard.getName().equalsIgnoreCase(card.getName())
                        && card.isFront()){
                    currentCard = card;
                    break;
                }
            }
        }

        final Drawable drawable=currentCard.getDrawable();
        final ImageView iv_ = iv;
        iv_.setRotationY(0f);
        iv_.animate().rotationY(90f).setListener(new AnimatorListenerAdapter()
        {
            @Override
            public void onAnimationEnd(Animator animation)
            {
                iv_.setImageDrawable(drawable);
                iv_.setRotationY(270f);
                iv_.animate().rotationY(360f).setListener(null);
            }
        });
    }

    private void loadDeck(){
        viewModel.loadDeck(this);
    }

    @Override
    public void onSuccess(List<Card> parameter) {
        if(parameter != null){
            cards = parameter;
            splitAndShuffle(false);
        }
    }

    @Override
    public void onError(Throwable throwable) {

    }

    public void splitAndShuffle(boolean isRailAge){

        currentDeckIndex = 0;
        deckA = new ArrayList<Card>();
        deckB = new ArrayList<Card>();
        deckC = new ArrayList<Card>();
        gameDeck = new ArrayList<Card>();

        if(isRailAge){
            for(Card card : cards){
                if(card.getName().startsWith("a") && card.isFront()) {
                    deckA.add(card);
                    Collections.shuffle(deckA);
                }
                else if(card.getName().startsWith("b") && card.isFront()) {
                    deckB.add(card);
                    Collections.shuffle(deckB);
                }
                else if(card.getName().startsWith("c") && card.isFront()) {
                    deckC.add(card);
                    Collections.shuffle(deckC);
                }
            }
        }else {
            for(Card card : cards){
                if(card.getName().startsWith("a") && card.isFront() && !card.isRailAge()) {
                    deckA.add(card);
                    Collections.shuffle(deckA);
                }
                else if(card.getName().startsWith("b") && card.isFront() && !card.isRailAge()) {
                    deckB.add(card);
                    Collections.shuffle(deckB);
                }
                else if(card.getName().startsWith("c") && card.isFront() && !card.isRailAge()) {
                    deckC.add(card);
                    Collections.shuffle(deckC);
                }
            }
        }

        gameDeck.add(deckA.remove(0));
        gameDeck.add(deckA.remove(0));
        gameDeck.add(deckA.remove(0));
        gameDeck.add(deckA.remove(0));
        gameDeck.add(deckB.remove(0));
        gameDeck.add(deckB.remove(0));
        gameDeck.add(deckB.remove(0));
        gameDeck.add(deckC.remove(0));
        gameDeck.add(deckC.remove(0));
        gameDeck.add(deckC.remove(0));

        List<Card> set3AutomaDec = new ArrayList<Card>();
        set3AutomaDec.add(deckA.remove(0));
        set3AutomaDec.add(deckB.remove(0));
        set3AutomaDec.add(deckC.remove(0));
        Collections.shuffle(set3AutomaDec);
        gameDeck.addAll(set3AutomaDec);


        List<Card> set4AutomaDec = new ArrayList<Card>();
        set4AutomaDec.addAll(deckA);
        set4AutomaDec.addAll(deckB);
        set4AutomaDec.addAll(deckC);
        Collections.shuffle(set4AutomaDec);
        gameDeck.addAll(set4AutomaDec);

        Collections.reverse(gameDeck);

        currentCard = gameDeck.get(currentDeckIndex);

        if(isRailAge){
            iv.setImageDrawable(currentCard.getDrawable());
        }else{
            for(Card card : cards){
                if(currentCard.getName().equalsIgnoreCase(card.getName())
                        && !card.isFront()){
                    currentCard = card;
                    iv.setImageDrawable(currentCard.getDrawable());
                    break;
                }
            }
        }
    }
}