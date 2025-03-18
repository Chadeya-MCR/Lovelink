<?php

namespace Database\Seeders;

use App\Models\User;
// use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;
use Illuminate\Support\Facades\Hash;

class DatabaseSeeder extends Seeder
{
    /**
     * Seed the application's database.
     */
    public function run(): void
    {
        // User::factory(10)->create();

        User::factory()->create([
            'username' => 'Test Chadeya',
            'email' => 'chadeyamorgan203@gmail.com',
            'phone'=>'0110178260',
            'password' => Hash::make('password123'),
            'dob'=>fake()->date(),
            'hobbies'=>'listening to music',
        ]);
    }
}
