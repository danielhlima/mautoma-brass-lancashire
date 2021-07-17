package br.com.mautomabrasslancashire.view.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import java.util.List;

import br.com.mautomabrasslancashire.R;
import br.com.mautomabrasslancashire.domain.bus.DataOut;
import br.com.mautomabrasslancashire.domain.entities.Card;
import br.com.mautomabrasslancashire.view.viewmodel.LoadDeckViewModel;

public class DeckTestFragment extends Fragment implements DataOut.Callback<List<Card>> {

    private ImageView iv;
    private LoadDeckViewModel viewModel;
    private int currentDeckIndex;
    private List<Card> cards;


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
                    Card card = cards.get(currentDeckIndex-1);
                    iv.setImageDrawable(card.getDrawable());
                    currentDeckIndex-=1;
                }
            }
        });

        ((Button)view.findViewById(R.id.bt_flip)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        ((Button)view.findViewById(R.id.bt_next)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentDeckIndex < cards.size()-1){
                    Card card = cards.get(currentDeckIndex+1);
                    iv.setImageDrawable(card.getDrawable());
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
            Card card = parameter.get(currentDeckIndex);
            iv.setImageDrawable(card.getDrawable());
        }
    }

    @Override
    public void onError(Throwable throwable) {

    }
}