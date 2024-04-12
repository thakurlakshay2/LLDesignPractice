package LockerManagementSystem.model;

public class Size {
    private final int width;

    private final int height;

    public Size(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public boolean canAccomodate(Size size){
          if(size.height*size.width<=this.height*this.width){
                return true;
          }else{
              return false
          }
    }
}
