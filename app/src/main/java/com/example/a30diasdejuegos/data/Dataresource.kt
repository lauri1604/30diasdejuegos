package com.example.a30diasdejuegos.data

import com.example.a30diasdejuegos.R
import com.example.a30diasdejuegos.model.Game

class Dataresource {
    fun loadGames(): List<Game> = listOf(
        Game(1, R.string.domino_title, R.string.domino_description, R.drawable.domino_pack),
        Game(2, R.string.game_animals, R.string.game_animals_description, R.drawable.animal_pack_remastered),
        Game(3, R.string.game_blaster, R.string.game_blaster_description, R.drawable.blaster_kit),
        Game(4, R.string.game_board_icons, R.string.game_board_icons_description, R.drawable.board_game_icons),
        Game(5, R.string.game_board_adventure, R.string.game_board_adventure_description, R.drawable.boardgame_pack),
        Game(6, R.string.game_cars, R.string.game_cars_description, R.drawable.car_kit),
        Game(7, R.string.game_fishing, R.string.game_fishing_description, R.drawable.fish_pack),
        Game(8, R.string.game_cooking, R.string.game_cooking_description, R.drawable.food_kit),
        Game(9, R.string.game_medieval, R.string.game_medieval_description, R.drawable.medieval_rts),
        Game(10, R.string.game_arcade, R.string.game_arcade_description, R.drawable.mini_arcade),
        Game(11, R.string.game_minigolf, R.string.game_minigolf_description, R.drawable.minigolf_kit),
        Game(12, R.string.game_monsters, R.string.game_monsters_description, R.drawable.monster_builder_pack),
        Game(13, R.string.game_nature, R.string.game_nature_description, R.drawable.nature_kit),
        Game(14, R.string.game_pirates, R.string.game_pirates_description, R.drawable.pirate_pack),
        Game(15, R.string.game_pixel_platform, R.string.game_pixel_platform_description, R.drawable.pixel_platformer),
        Game(16, R.string.game_platform_adventure, R.string.game_platform_adventure_description, R.drawable.platformer_art_deluxe),
        Game(17, R.string.game_platform_challenge, R.string.game_platform_challenge_description, R.drawable.platformer_pack_remastered),
        Game(18, R.string.game_cards, R.string.game_cards_description, R.drawable.playing_cards_pack),
        Game(19, R.string.game_puzzle_one, R.string.game_puzzle_one_description, R.drawable.puzzle_pack_1),
        Game(20, R.string.game_puzzle_two, R.string.game_puzzle_two_description, R.drawable.puzzle_pack_2),
        Game(21, R.string.game_racing, R.string.game_racing_description, R.drawable.racing_pack),
        Game(22, R.string.game_robots, R.string.game_robots_description, R.drawable.robot_pack),
        Game(23, R.string.game_target, R.string.game_target_description, R.drawable.shooting_gallery),
        Game(24, R.string.game_sokoban, R.string.game_sokoban_description, R.drawable.sokoban),
        Game(25, R.string.game_space_shooter, R.string.game_space_shooter_description, R.drawable.space_shooter_remastered),
        Game(26, R.string.game_sports, R.string.game_sports_description, R.drawable.sports_pack),
        Game(27, R.string.game_tappy_plane, R.string.game_tappy_plane_description, R.drawable.tappy_plane),
        Game(28, R.string.game_farm, R.string.game_farm_description, R.drawable.tiny_farm),
        Game(29, R.string.game_tanks, R.string.game_tanks_description, R.drawable.top_down_tanks_remastered),
        Game(30, R.string.game_tower_defense, R.string.game_tower_defense_description, R.drawable.tower_defense)
    )
}
