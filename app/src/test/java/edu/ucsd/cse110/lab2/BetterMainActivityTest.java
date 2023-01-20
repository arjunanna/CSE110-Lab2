package edu.ucsd.cse110.lab2;

import android.widget.Button;
import android.widget.TextView;

import androidx.lifecycle.Lifecycle;
import androidx.test.core.app.ActivityScenario;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class BetterMainActivityTest {

    @Test
    public void test_one_plus_one_equals_two() {
        var scenario = ActivityScenario.launch(MainActivity.class);
        scenario.moveToState(Lifecycle.State.CREATED);
        scenario.moveToState(Lifecycle.State.STARTED);

        scenario.onActivity(activity -> {
            Button button_one = (Button) activity.findViewById(R.id.btn_one);
            Button button_plus = (Button) activity.findViewById(R.id.btn_plus);
            Button button_equals = (Button) activity.findViewById(R.id.btn_equals);
            TextView text = (TextView) activity.findViewById(R.id.display);
            button_one.performClick();
            button_plus.performClick();
            button_one.performClick();
            button_equals.performClick();

            assertEquals("2", text.getText());
        });
    }

}
