<?php

namespace App\Http\Controllers\Auth;

use App\Http\Controllers\Controller;
use App\Models\User;
use Illuminate\Auth\Events\Registered;
use Illuminate\Http\Request;
use Illuminate\Http\Response;
use Illuminate\Support\Facades\Auth;
use Illuminate\Support\Facades\Hash;
use Illuminate\Validation\Rules;

class RegisteredUserController extends Controller
{
    /**
     * Handle an incoming registration request.
     *
     * @throws \Illuminate\Validation\ValidationException
     */
    public function register(Request $request)
    {
        $request->validate([
            'username' => ['required', 'string', 'max:100'],
            'email' => ['required', 'string', 'lowercase', 'email', 'max:255', 'unique:users,email'],
            'phone'=>['required', 'digits_between:9-14'],
            'password' => ['required', 'confirmed', Rules\Password::defaults()],
            'dob'=>['required', 'date'],
            'hobbies'=>['required'],
            'profile_picture' => ['required', 'image', 'mimes:jpeg,png,jpg', 'max:2048'],
            'cover_photo' => ['required', 'image', 'mimes:jpeg,png,jpg', 'max:2048'],
        ]);

        if ($request->hasFile('profile_picture') && $request->hasFile('cover_photo')) {
            $profile_path = $request->file('profile_picture')
                ->store('images', 'public');
            $cover_path = $request->file('cover_photo')
            ->store('images', 'public');
        }
        
        $user = User::create([
           'username' => $request->username,
           'email'=> $request->email,
           'phone'=>$request->phone,
           'password'=>Hash::make($request->password),
           'dob'=>$request->dob,
           'hobbies'=>$request->hobbies,
           'profile_picture'=>$profile_path,
           'cover_photo'=>$cover_path
        ]);

        $token = $user->createToken('mobile-app')->plainTextToken;

        return response()->json([
            'user' => $user,
            'token' => $token,
            'message' => 'User registered successfully'
        ], 201);
    }
}
