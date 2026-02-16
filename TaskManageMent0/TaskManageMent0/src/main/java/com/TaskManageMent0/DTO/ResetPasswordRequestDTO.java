package com.TaskManageMent0.DTO;

public class ResetPasswordRequestDTO {

   public String token ;
   public String newPassword ;


   public String getToken() {
      return token;
   }

   public String getNewPassword() {
      return newPassword;
   }

   public void setToken(String token) {
      this.token = token;
   }

   public void setNewPassword(String newPassword) {
      this.newPassword = newPassword;
   }
}
