<?php
   $db_host = "localhost";
   $db_database = "lostandfound";
   $db_username = "root";
   $db_password = "database";
   mysql_connect($db_host, $db_username, $db_password);
   mysql_select_db($db_database);
   $q=mysql_query("SELECT * FROM LostFound2");
   while($e=mysql_fetch_assoc($q))
   $output[]=$e;
   print(json_encode($output));
   mysql_close();
?>
