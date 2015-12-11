package entities;

import com.badlogic.gdx.math.Rectangle;

/**
 * A simple class to check collisions given the bounding boxes 
 * ednecia
 */

public class CollisionChecker {

    public static boolean collide(Entity e2,Entity e,Rectangle r1, Rectangle r2) {
        // Get shifting amounts
        
        // Loop through making sure to stay within bounds
       /* for (int i = 0; i < Math.min(r1.height, r2.height - upDownShift); i++) {
            // just check if the boxes collide, if they do a collision occured
            if (i + upDownShift > 0 && (i + upDownShift) < Math.min( two.length, one.length )) {
                // Bitshift and compare to correct row of other mask
                if (leftRightShift > 0) {
                 //   if (((one[i] >>> leftRightShift) & two[(i + upDownShift)]) != 0) {
                 //       System.out.println("Collision");
                 //       return true;
                    }
                } else {
                   /* if (((one[i] << Math.abs(leftRightShift)) & two[((i + upDownShift))]) != 0) {
                        System.out.println("Collision");
                        return true;
                    }//no bit checking needed
                }
            }
        } */
        // No collisions found
        return false;
    }
}
