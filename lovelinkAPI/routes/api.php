<?php

use App\Http\Controllers\Auth\AuthenticatedSessionController;
use App\Http\Controllers\Auth\RegisteredUserController;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;

Route::middleware(['auth:sanctum'])
    ->controller(AuthenticatedSessionController::class)
    ->group(function(){

    Route::post('/login', 'store')->name('login');
    Route::post('/logout', 'destroy')->name('logout');

});
Route::middleware(['auth:sanctum'])
    ->controller(RegisteredUserController::class)
    ->group(function(){

    Route::post('/register', 'store')->name('register');

});