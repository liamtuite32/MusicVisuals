package c21415142;

public class vector3
{
    public float x;
    public float y;
    public float z;

    //Methods
    public vector3(float X, float Y, float Z)
    { 
        this.x = X; 
        this.y = Y; 
        this.z = Z; 
    }
    public vector3(int X, int Y, int Z)
    { 
        this.x = (float)X; 
        this.y = (float)Y; 
        this.z = (float)Z; 
    }
    public vector3(float X, float Y)
    { 
        this.x = X; 
        this.y = Y; 
        this.z = 0; 
    }
    public vector3(int X, int Y)
    { 
        this.x = (float)X; 
        this.y = (float)Y; 
        this.z = 0f; 
    }

    public vector3(float X)
    { 
        this.x = X; 
        this.y = X; 
        this.z = X; 
    }
    
    public vector3()
    { 
        this.x = 0; 
        this.y = 0; 
        this.z = 0; 
    }
    
    public void reset()
    {
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    // operator shenanigins - VECTOR
    public vector3 add(vector3 other_vector) // +
    {
        return new vector3( (this.x + other_vector.x), 
                            (this.y + other_vector.y),    
                            (this.z + other_vector.z) );
    }
    
    public vector3 minus(vector3 other_vector) // -
    {
        return new vector3( (this.x - other_vector.x), 
                            (this.y - other_vector.y),    
                            (this.z - other_vector.z) );
    }
    
    public vector3 times(vector3 other_vector) // multiply
    {
        return new vector3( (this.x * other_vector.x), 
                            (this.y * other_vector.y),    
                            (this.z * other_vector.z) );
    }
    
    public vector3 divide(vector3 other_vector) // divide
    {
        return new vector3( (this.x / other_vector.x), 
                            (this.y / other_vector.y),    
                            (this.z / other_vector.z) );
    }    

    // operator shenanigins - FLOAT
    public vector3 add(float amount) // +
    {
        return new vector3( (this.x + amount), 
                            (this.y + amount),    
                            (this.z + amount) );
    }
    
    public vector3 minus(float amount) // -
    {
        return new vector3( (this.x - amount), 
                            (this.y - amount),    
                            (this.z - amount) );
    }
    
    public vector3 times(float amount) // multiply
    {
        return new vector3( (this.x * amount), 
                            (this.y * amount),    
                            (this.z * amount) );
    }
    
    public vector3 divide(float amount) // divide
    {
        return new vector3( (this.x / amount), 
                            (this.y / amount),    
                            (this.z / amount) );
    }    

    public String string_version(int decimal_places)
    {
        String postion_str = ""; 
        int multiplier = 10 ^ decimal_places;

        // multiply numbers by
        postion_str += "X: " + Float.toString(Math.round( this.x *multiplier) / multiplier);
        postion_str += " | Y: " + Float.toString(Math.round( this.y *multiplier) / multiplier);
        postion_str += " | Z: " + Float.toString(Math.round( this.z *multiplier) / multiplier);
    
        return postion_str;
    }

    public String string_version()
    {
        return this.string_version(2);
    }

    public void rotate_around_point(vector3 origin, float degrees)
    {
        // Thank you StackOverFlow
        float rads = (float)Math.toRadians(degrees);
        float cos_theta = (float)Math.cos(rads);
        float sin_theta = (float)Math.sin(rads);

        float shifted_x = this.x - origin.x;
        float shifted_y = this.y - origin.y;
        float shifted_z = this.z - origin.z;

        // rotation magic
        this.x = (shifted_x*cos_theta) - (shifted_z*sin_theta) + origin.x;
        this.y = shifted_y + origin.y;
        this.z = (shifted_x*sin_theta) + (shifted_z*cos_theta) + origin.z;
    }

    public void move_to_point(vector3 destination, float amount) 
    {
        float offset_x = (destination.x - this.x) * amount;
        float offset_y = (destination.y - this.y) * amount;
        float offset_z = (destination.z - this.z) * amount;

        this.x += offset_x;
        this.y += offset_y;
        this.z += offset_z;
    }



}// end vector class
