package com.example.ViewModels;

import java.util.Calendar;
import java.text.SimpleDateFormat;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;
import android.app.Activity;
import android.widget.Button;
import android.util.DisplayMetrics;



import com.example.R;
import com.example.Models.Room;

public class GameScreen extends Activity {

    //Difficulty Property
    double difficulty;
    // Character Sprite
    ImageView character;
    // Character Selection
    int charInt;
    // Player score
    static int score;
    //number of attempts
    static int attempt;


    Room room;

    int screenWidth;
    int screenHeight;

    public GameScreen () {}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Set gamescreen as current screen for user
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamescreen);


        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        screenWidth = displayMetrics.widthPixels;
        screenHeight = displayMetrics.heightPixels;


        // Initialize the Room with the screen dimensions
        room = new Room(this, screenWidth, screenHeight);
        // Start drawing the room background
        drawRoomBackground();

        // Initialize difficultyText to display difficulty user selected
        TextView difficultyText = (TextView) findViewById(R.id.difficultyTextView);
        attempt++;

        // Initialize nameText to display name user inputted
        TextView nameText = (TextView) findViewById(R.id.nameTextView);
        String name = getIntent().getStringExtra("playerName");
        nameText.setText("Name: " + name);

        // Displays the difficulty user selected as well as health associated with chosen difficulty
        difficulty = getIntent().getDoubleExtra("difficulty", 0.5);
        String health = "100";
        if (difficulty == 1) {
            difficultyText.setText("Difficulty: Hard");
            health = "100";
        } else if (difficulty == 0.75) {
            difficultyText.setText("Difficulty: Medium");
            health = "150";
        } else if (difficulty == 0.5) {
            difficultyText.setText("Difficulty: Easy");
            health = "200";
        } // if

        // Changes the sprite to the one user selected
        character = (ImageView) findViewById(R.id.characterImage);
        charInt = getIntent().getIntExtra("character", 1);
        if (charInt == 1) {
            character.setImageResource(R.drawable.knight_f_idle_anim_f0);
        } else if (charInt == 2) {
            character.setImageResource(R.drawable.elf_f_idle_anim_f0);
        } else if (charInt == 3) {
            character.setImageResource(R.drawable.dwarf_f_idle_anim_f3);
        } // if

        // Displays health based on difficulty
        TextView healthText = (TextView) findViewById(R.id.healthTextView);
        healthText.setText("Health: " + health);

        // displays the score and decrements it every 2 seconds
        TextView scoreText = findViewById(R.id.scoreTextView);
        score = 100;

        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                scoreText.setText("Score: " + score);
                if (score > 0) {
                    score -=5;
                }
                handler.postDelayed(this, 2000);
            }
        };
        handler.postDelayed(runnable, 0);

        // Get the current date and time
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String dateTime = dateFormat.format(calendar.getTime());

        //temporary next button
        Button nextButton = findViewById(R.id.nextButton);
        nextButton.setOnClickListener(v -> {
            // Handle "Next" button click
            room.nextTile();
            drawRoomBackground();
        });

        // Implements endButton functionality to send user to endscreen
        Button endButton = findViewById(R.id.endScreenButton);
        endButton.setOnClickListener(v -> {
            Intent end = new Intent(GameScreen.this, EndScreen.class);
            startActivity(end);
            finish();
        }); // endButton

    } // onCreate



    private void drawRoomBackground() {
        // Create a Bitmap to draw the room background
        Bitmap roomBitmap = Bitmap.createBitmap(screenWidth, screenHeight, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(roomBitmap);

        // Draw the room on the canvas (Replace with your Room class logic)
        room.draw(canvas);

        // Find the ImageView for the roomCanvas
        ImageView roomCanvas = findViewById(R.id.roomCanvas);

        // Set the Bitmap as the source for the ImageView
        roomCanvas.setImageBitmap(roomBitmap);
    }


    public static int getScore() {
        return score;
    }
    public static void resetScore(){
        score = 100;
    }
    public static int getAttempt() {
        return attempt;
    }

} // GameScreen
