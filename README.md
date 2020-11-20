# SOP_ShippingModule
<p align="center">
  <img src="https://i.imgur.com/5LtmN9S.png">
</p>

### ตาราง shipping_option
<ul>
<li>id : หมายเลข option</li>
<li>name : ชื่อผู้ให้บริการจัดส่ง ex. Kerry express, Shopee express, Lazada express</li>
<li>period : ช่วงเวลาที่จัดส่ง</li>
<li>price : ราคาการจัดส่ง</li>
<li>time_estimate : เวลาที่คาดไว้ในการจัดส่ง</li>
<li>item_id : หมายเลขสินค้า</li>
</ul>

### ตาราง shipping_detail 
<ul>
<li>id : หมายเลขรายละเอียดการจัดส่ง</li>
<li>address : ที่อยู่การจัดส่ง</li>
<li>order_id : หมายเลข order</li>
<li>shipping_log : log การจัดส่ง</li>
<li>status : ???</li>
</ul>

### ตาราง shipping_item_status 
<ul>
<li>id : หมายเลขสถานะการจัดส่ง</li>
<li>time : เวลา</li>
<li>detail : รายละเอียด</li>
<li>type : ???</li>
<li>shipping_detail_id : หมายเลขรายละเอียดการจัดส่ง</li>
</ul>

### ตาราง order
<ul>
<li>id : หมายเลข order</li>
<li>shipping_option_id : หมายเลข option</li>
<li>shop_id : หมายเลข shop</li>
</ul>

### ตาราง item_mockup
<ul>
<li>id : หมายเลข item</li>
</ul>

### ตาราง shop_mockup
<ul>
<li>id : หมายเลขสินค้า </li>
</ul>
