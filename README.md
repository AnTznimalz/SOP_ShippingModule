# SOP_ShippingModule

### สมาชิกกลุ่ม
<ol>
  <li> นายจิรัฐ ทองเพ็ง รหัสนักศึกษา 61070027</li>
  <li> นายธัชพันธุ์ อภิวิชญ์ชลชาติ รหัสนักศึกษา 61070085</li>
  <li> นายเวรุวัฒน์ ไชยดิษฐ์ รหัสนักศึกษา 61070214</li>
  <li> นายศรัณญ์ หาญทองคำ รหัสนักศึกษา 61070216</li>
  <li> นายอศลย์ อุฒาธรรม รหัสนักศึกษา 61070262</li>
</ol>

### Service Diagram
<img src="">
<ul>
<li>Shipping Option Service : ทำหน้าที่ให้บริการการจัดการ Shipping Option (ช่องทางการจัดส่งของสินค้านั้นๆ)</li>
<li>Shipping Order Service : ทำหน้าที่ให้บริการการจัดการ Shipping Order(ข้อมูลของการจัดส่ง) เปลี่ยนสถานะ อัพเดทการจัดส่งต่างๆ</li>
<li>Tracking Service : ทำหน้าที่เกี่ยวกับติดต่อกับ ไปรษณีย์ไทย เพื่อเช็คเลขแทรคต่างๆ</li>
</ul>

### วิธีใช้งาน
<ul>
<li>Run JAVA Application ที่ไฟล์ ShippingOrderController.java</li>
  <li>พิมพ์ url : http://localhost:8761/swagger-ui.html ลงใน browser</li>
  <li>ปล.เลข port อาจมีการเปลี่ยนแปลงได้ให้เข้าไปเช็คที่ ShippingModule/application.yml</li>
  <li>สามารถเรียกใช้ method ต่าง ๆ ได้ตามที่ต้องการผ่าน application POSTMAN โดยดู parameter ต่าง ๆ ได้ที่ Swagger </li>
</ul>
 
 ### Module อื่น ๆ ที่เกี่ยวข้อง
 <ul>
  <li>Module Shop : https://github.com/Peechanok/Group-Lamp-SOP</li>
   <li>Module Order :  https://github.com/tawan21222423/OrderModule</li>
  <li>Module Product : https://github.com/tanknk/ECommerceSystem</li>
  </ul>
