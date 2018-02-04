<?php

	$con = mysqli_connect("127.0.0.1","root","","bsru");
	// // var_dump($con);
	// $_POST["user"] = "admin";
	// $_POST["pass"] = "1234";
	$user_str = $_POST["user"];
	$pass_str = $_POST["pass"];

	$sql_command = "SELECT * FROM `member` WHERE user = '{$user_str}' and pass = '{$pass_str}'";

	

	$query = mysqli_query($con,$sql_command);

	
	$return = array();
	if(mysqli_num_rows($query) > 0 ){
		$return["status"] = true;
		$return["message"] = "welcome {$user_str}";
	}else{
		$return["status"] = false;
		$return["message"] = "not found user";
	}


	echo json_encode($return);






?>