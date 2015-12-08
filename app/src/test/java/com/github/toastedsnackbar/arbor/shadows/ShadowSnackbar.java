package com.github.toastedsnackbar.arbor.shadows;

import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;

import org.robolectric.annotation.Implementation;
import org.robolectric.annotation.Implements;
import org.robolectric.annotation.RealObject;
import org.robolectric.internal.ShadowExtractor;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"UnusedDeclaration", "Unchecked"})
@Implements(Snackbar.class)
public class ShadowSnackbar {

    public static List<ShadowSnackbar> sShadowSnackbars = new ArrayList<>();

    @RealObject
    Snackbar mSnackbar;

    String mText;
    private int mDuration;
    private int mGravity;
    private int mXOffset;
    private int mYOffset;
    private View mView;

    @Implementation
    public static Snackbar make(@NonNull View view, @NonNull CharSequence text, int duration) {
        Snackbar snackbar = null;

        try {
            Constructor<Snackbar> constructor = Snackbar.class.getDeclaredConstructor(ViewGroup.class);

            //just in case, maybe they'll change the method signature in the future
            if (null == constructor)
                throw new IllegalArgumentException("Seems like the constructor was not found!");


            if (Modifier.isPrivate(constructor.getModifiers())) {
                constructor.setAccessible(true);
            }

            snackbar = constructor.newInstance(findSuitableParent(view));
            snackbar.setText(text);
            snackbar.setDuration(duration);
        } catch (Exception e) {
            e.printStackTrace();
        }

        shadowOf(snackbar).mText = text.toString();

        sShadowSnackbars.add(shadowOf(snackbar));

        return snackbar;
    }

    private static ViewGroup findSuitableParent(View view) {
        ViewGroup fallback = null;

        do {
            if (view instanceof CoordinatorLayout) {
                return (ViewGroup) view;
            }

            if (view instanceof FrameLayout) {
                /*
                if(mView.getId() == 16908290) {
                    return (ViewGroup) mView;
                }
                */

                fallback = (ViewGroup) view;
            }

            if (view != null) {
                ViewParent parent = view.getParent();
                view = parent instanceof View ? (View) parent : null;
            }
        } while (view != null);

        return fallback;
    }

    @Implementation
    public static Snackbar make(@NonNull View view, @StringRes int resId, int duration) {
        return make(view, view.getResources().getText(resId), duration);
    }


    static ShadowSnackbar shadowOf(Snackbar bar) {
        return (ShadowSnackbar) ShadowExtractor.extract(bar);
    }

    public static void reset() {
        sShadowSnackbars.clear();
    }

    public static int shownSnackbarCount() {
        return sShadowSnackbars.isEmpty() ? 0 : sShadowSnackbars.size();

    }

    public static String getTextOfLatestSnackbar() {
        if (!sShadowSnackbars.isEmpty())
            return sShadowSnackbars.get(sShadowSnackbars.size() - 1).mText;

        return null;
    }

    public static Snackbar getLatestSnackbar() {
        if (!sShadowSnackbars.isEmpty())
            return sShadowSnackbars.get(sShadowSnackbars.size() - 1).mSnackbar;

        return null;
    }
}
