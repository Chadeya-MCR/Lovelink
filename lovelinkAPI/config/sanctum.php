<?php

use Laravel\Sanctum\Sanctum;

return [

    /*
    |--------------------------------------------------------------------------
    | Stateful Domains
    |--------------------------------------------------------------------------
    |
    | Requests from these domains will receive stateful API authentication
    | cookies. This should include frontend SPA and mobile app hosts.
    |
    */

    'stateful' => explode(',', env('SANCTUM_STATEFUL_DOMAINS', sprintf(
        '%s%s%s',
        'localhost,localhost:3000,127.0.0.1,127.0.0.1:3000,127.0.0.1:8000,::1,192.168.43.186 ,192.168.43.186 :8000',
        Sanctum::currentApplicationUrlWithPort(),
        env('FRONTEND_URL') ? ','.parse_url(env('FRONTEND_URL'), PHP_URL_HOST) : ''
    ))),

    /*
    |--------------------------------------------------------------------------
    | Sanctum Guards
    |--------------------------------------------------------------------------
    |
    | This array contains authentication guards that will be checked when
    | Sanctum authenticates a request. This includes both web (SPA) and
    | API requests.
    |
    */

    'guard' => ['web', 'api'],

    /*
    |--------------------------------------------------------------------------
    | Expiration Minutes
    |--------------------------------------------------------------------------
    |
    | Controls how long tokens remain valid before expiring. A value of `null`
    | means tokens do not expire unless explicitly revoked.
    |
    */

    'expiration' => 525600, // 1 year (change as needed)

    /*
    |--------------------------------------------------------------------------
    | Token Prefix
    |--------------------------------------------------------------------------
    |
    | Prefix added to tokens for security scanning purposes.
    |
    */

    'token_prefix' => env('SANCTUM_TOKEN_PREFIX', 'lovelink'),

    /*
    |--------------------------------------------------------------------------
    | Sanctum Middleware
    |--------------------------------------------------------------------------
    |
    | Middleware settings for API authentication.
    |
    */

    'middleware' => [
        'authenticate_session' => Laravel\Sanctum\Http\Middleware\AuthenticateSession::class,
        'encrypt_cookies' => Illuminate\Cookie\Middleware\EncryptCookies::class,
        // Removed CSRF validation for API calls
    ],

];
