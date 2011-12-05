<?php
 mysql_connect("localhost","root","database");
 mysql_select_db("lostandfound");

 $foundlocation = $_POST['foundlocation'];
 $item = $_POST['item'];
 $date = $_POST['date'];
 $picklocation = $_POST['picklocation'];
 $email = $_POST['email'];
 $phone = $_POST['phone'];
 $description = $_POST['description'];

 $sql1 = "insert into LostFound2 values('$foundlocation', '$item', '$date', '$description', '$email', '$phone', '$picklocation')";
 mysql_query($sql1) or die(mysql_error());
 $sql2 = "select * from LostFound2";
 $query = mysql_query($sql2);
 while($row = mysql_fetch_array($query)){
   echo $row['location'];
   echo $row['item'];
 } 
?>

