<?php
session_start();
if(!array_key_exists('ultimo_login', $_SESSION)){
	$_SESSION['ultimo_login'] = date('H:i:s d/m/Y');
}
if(!array_key_exists('reqs', $_SESSION)){
	$_SESSION['reqs'] = 1;
} else {
	$_SESSION['reqs']++;
}