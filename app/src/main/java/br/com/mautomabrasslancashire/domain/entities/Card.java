package br.com.mautomabrasslancashire.domain.entities;

import android.graphics.drawable.Drawable;

public class Card {

    private String name;
    private boolean isClassic;
    private boolean mustHave;
    private boolean isFront;
    private Drawable drawable;
    private boolean isRailAge;

    public Card(String name, boolean isClassic, boolean mustHave, boolean isFront, Drawable drawable,
                boolean isRailAge) {
        this.name = name;
        this.isClassic = isClassic;
        this.mustHave = mustHave;
        this.isFront = isFront;
        this.drawable = drawable;
        this.isRailAge = isRailAge;
    }

    public boolean isRailAge() {
        return isRailAge;
    }

    public String getName() {
        return name;
    }

    public boolean isClassic() {
        return isClassic;
    }

    public boolean isMustHave() {
        return mustHave;
    }

    public boolean isFront() {
        return isFront;
    }

    public Drawable getDrawable() {
        return drawable;
    }
}
