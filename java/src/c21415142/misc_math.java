package c21415142;

import c21415142.vector3;

public class misc_math
{
    static public float Clamp(float min, float max, float value) // keep a value in range of something
    {
        if (value > max)
        {
            return max;
        }
        else if (value < min)
        {
            return min;
        }
        else
        {
            return value;
        }
    }

    static public float Lerp(float x, float y, float alpha)
    {
        return x + (y - x) * Clamp(0,1,alpha);
    }
    
    static public vector3 Lerp(vector3 vector_1, vector3 vector_2, float alpha)
    {
        float x = Lerp(vector_1.x, vector_2.x, alpha);
        float y = Lerp(vector_1.y, vector_2.y, alpha);
        float z = Lerp(vector_1.z, vector_2.z, alpha);
        
        return new vector3(x,y,z);
    }
    
    static public float Calculate_Alpha(float start, float end, float value)
    {
        return (value - start) / (end - start);
    }
    
}// end vector class
