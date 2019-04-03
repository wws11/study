package test.sort;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/4/2 17:32
 */

public class Start  {

   private  String  unitAttrName;
   private  String   unitName;

   public String getUnitAttrName() {
      return unitAttrName;
   }

   public void setUnitAttrName(String unitAttrName) {
      this.unitAttrName = unitAttrName;
   }

   public String getUnitName() {
      return unitName;
   }

   public void setUnitName(String unitName) {
      this.unitName = unitName;
   }

   @Override
   public String toString() {
      return "Start{" +
              "unitAttrName='" + unitAttrName + '\'' +
              ", unitName='" + unitName + '\'' +
              '}';
   }
}
