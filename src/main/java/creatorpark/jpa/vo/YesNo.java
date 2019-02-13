package creatorpark.jpa.vo;

import lombok.Getter;

@Getter
public enum YesNo {

  Y              ("예"    ),
  N              ("아니오" ); 
    
  String descKo; 
  
  private YesNo(String descKo) {
    this.descKo = descKo; 
  }
    
  @Override  
  public String toString() {
    return this.name();
  }
  
  public static YesNo findByCode(String code) {
    for (YesNo e : YesNo.class.getEnumConstants()) {
      if (code.equals(e.name())) {
        return e;
      }
    }
    return null;
  }
  
}
