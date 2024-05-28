public class Solution {

    public int minSubArrayLen(int target, int[] nums) {
        //Paso#1
        int valorMinimo = 9999999;
        int suma = 0;
        int izquierda = 0;
        int derecha = 0;
        
        //Paso#2
        for (derecha = 0; derecha < nums.length; derecha++) {
            suma += nums[derecha];

            //paso#3
            while (suma >= target) {
                //paso#4
                valorMinimo = Math.min(valorMinimo, derecha - izquierda + 1);
                suma -= nums[izquierda];
                izquierda++;
            }
        }

        //paso#5
        return valorMinimo == 9999999 ? 0 : valorMinimo;
    }
}