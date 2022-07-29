package com.example.informisime.Fragments.ui.main;

import android.media.Image;
import android.view.View;
import android.widget.ImageView;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.example.informisime.R;

public class PageViewModel extends ViewModel {

    private MutableLiveData<Integer> mIndex = new MutableLiveData<>();

    private LiveData<String> mText = Transformations.map(mIndex, new Function<Integer, String>() {
        @Override
        public String apply(Integer input) {
            if(input==1){

                return "Informiši.me ";
            }
            if(input==2){

                return "Ako ne znaš kojim putem da  kreneš  pogledaj aplikaciju \n" +
                        "Informiši.me. Ona će ti omogućiti da dobiješ sve potrebne informacije  za upisu I razred srednje škole u Crnoj Gori.\n";
            }
            if(input==3){

                return "Aplikaciju su razvili učenici Srednje elektrotehničke škole ''Vaso Aligrudić'' iz  Podgorice, uz podršku mentora i u saradnji sa Ministarstvom prosvjete Crne Gore.";
            }
            if(input==4){

                return "Za pokretanje aplikacije pritisnuti dugme u donjem desnom uglu. Nakon toga ovaj prozor se neće više pojavljivati.";
            }
            return ":(";
        }
    });



    public void setIndex(int index) {
        mIndex.setValue(index);
    }

    public LiveData<String> getText() {
        return mText;
    }
}