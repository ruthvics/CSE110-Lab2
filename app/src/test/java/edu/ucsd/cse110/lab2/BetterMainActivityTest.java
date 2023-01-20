package edu.ucsd.cse110.lab2;

import static org.junit.Assert.assertEquals;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.lifecycle.Lifecycle;
import androidx.test.core.app.ActivityScenario;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(RobolectricTestRunner.class)
public class BetterMainActivityTest {

        @Test
        public void test_one_plus_one_equals_two () {
            var scenario = ActivityScenario. launch (MainActivity.class);



            scenario.moveToState(Lifecycle.State.CREATED);
            scenario. moveToState (Lifecycle.State.STARTED);
            scenario.onActivity(activity -> {
            Button oneButton = (Button) activity.findViewById(R.id.btn_one);
            /*oneButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    // Code here executes on main thread after user presses button
                }
            });*/
            oneButton.performClick();
            Button plusButton = (Button) activity.findViewById(R.id.btn_plus);
            plusButton.performClick();

            //Button twoButton = (Button) activity.findViewById(R.id.btn_one);
            oneButton.performClick();

            Button equalButton = (Button) activity.findViewById(R.id.btn_equals);
            equalButton.performClick();

            TextView display = (TextView) activity.findViewById(R.id.display);
            System.out.println("Reached here~");
            assertEquals("2",display.getText());
            //assertThat((String) display.getText()).isEqualTo("2");
            });

        }
}
