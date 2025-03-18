<?php

namespace App\Http\Controllers\Auth;

use App\Http\Controllers\Controller;
use App\Http\Requests\Auth\LoginRequest;
use Illuminate\Http\Request;
use Illuminate\Http\Response;
use Illuminate\Support\Facades\Auth;

class AuthenticatedSessionController extends Controller
{
    /**
     * Handle an incoming authentication request.
     */
    public function store(LoginRequest $request): Response
    {
        if (!$request->authenticate()) {
            return response()->json([
                'message' => 'Invalid credentials'
            ], 401);
        }
    
        $request->session()->regenerate();
    
        $user = $request->user();
    
        $token = $user->createToken('mobile-app')->plainTextToken;
    
        return response()->json([
            'user' => $user,
            'token' => $token,
            'message' => 'User logged in successfully'
        ], 200);
    }
    

    /**
     * Destroy an authenticated session.
     */
    public function destroy(Request $request): Response
    {
        Auth::guard('web')->logout();

        $request->session()->invalidate();

        $request->session()->regenerateToken();

        return response()->json([
            'message' => 'User logged out successfully'
        ], 200);
    }
}
