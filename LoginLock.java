

public class LoginLock {
   public static void main(String[] args) {
      String[] var1 = new String[]{"wrong", "wrong", "wrong"};
      int var2 = 0;

      for(String var6 : var1) {
         if (!var6.equals("wrong")) {
            System.out.println("Login Successful");
            return;
         }

         ++var2;
         if (var2 == 3) {
            System.out.println("Account Locked");
            return;
         }
      }

   }
}

