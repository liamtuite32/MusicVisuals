package ie.tudublin;

import processing.core.PFont;

public class Sketch_Select extends Visual {




    PFont heading;
    PFont font;
    static int chosen_visual = -1;

    button[] buttons = new button[8];

    class button {
        int button_width;
        int button_height;
        int button_start_x;
        int button_start_y;
        int[] button_colour = { 200, 100, 100 };
        int[] button_colour_hovered = { 100, 200, 0 };
        String button_text;
        boolean is_hovered = false;
        int corolates_to_what_visual;

        public button(int x, int y, int but_width, int but_height, String text, int visual_id) {
            button_start_x = x;
            button_start_y = y;
            button_width = but_width;
            button_height = but_height;
            button_text = text;
            corolates_to_what_visual = visual_id;
        }

        void draw_button() 
        {
            if ((mouseX >= button_start_x && mouseX <= button_start_x + button_width)
                    &&
                    (mouseY >= button_start_y && mouseY <= button_start_y + button_height)) {
                is_hovered = true;
            }

            else {
                is_hovered = false;
            }

            if (is_hovered == true) {
                fill(button_colour_hovered[0], button_colour_hovered[1], button_colour_hovered[2]);
            } else {
                fill(button_colour[0], button_colour[1], button_colour[2]);
            }

            stroke(255);
            rect(button_start_x, button_start_y, button_width, button_height);
            textFont(font);
            textAlign(CENTER, CENTER);
            fill(255);
            text(button_text, button_start_x + (button_width / 2), button_start_y + (button_height / 2));
        }
    }

    public void settings() 
    {
        size(400, 200);
    }


    public void setup() {

        // Create the font
        heading = createFont("Arial", 18);
        font = createFont("Arial", 12);
        textFont(font);

        buttons[0] = new button((1 *    (width / 21)), 2 * (height / 7), (4 * width/21), height / 5, "Long Walk\nHome", 0);
        buttons[1] = new button((6 *    (width / 21)), 2 * (height / 7), (4 * width/21), height / 5, "Hello 2", 1);
        buttons[2] = new button((11 *   (width / 21)), 2 * (height / 7), (4 * width/21), height / 5, "Hello 1", 2);
        buttons[3] = new button((16 *   (width / 21)), 2 * (height / 7), (4 * width/21), height / 5, "Hello 2", 3);
        buttons[4] = new button((1 *    (width / 21)), 4 * (height / 7), (4 * width/21), height / 5, "Hello 1", 4);
        buttons[5] = new button((6 *    (width / 21)), 4 * (height / 7), (4 * width/21), height / 5, "Hello 2", 5);
        buttons[6] = new button((11 *   (width / 21)), 4 * (height / 7), (4 * width/21), height / 5, "Hello 2", 6);
        buttons[7] = new button((16 *   (width / 21)), 4 * (height / 7), (4 * width/21), height / 5, "Hello 2", 7);
    }

    public void mousePressed() 
    {
        for (button which_button : buttons) 
        {
            if (which_button.is_hovered == true) 
            {
                chosen_visual = which_button.corolates_to_what_visual;
                println("Chosen Visual ("+which_button.corolates_to_what_visual+") == " + chosen_visual);
            }
        }
    }

    
    public int return_choice()
    {
        if(chosen_visual < 0 || chosen_visual > 7)
        {
            return -1;
        }
        
        else
        {
            return chosen_visual;
        }
    }

    public void draw() 
    {
        background(150);

        textAlign(CENTER, TOP);
        textFont(heading);
        text("Please select and enjoy a Music Visual :", width / 2, 10, 20);
        
        for (button which_button : buttons) 
        {
            which_button.draw_button();
        }
    }

    
}
