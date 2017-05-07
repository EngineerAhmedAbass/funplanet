package com.Fun.Game;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class GameService {

	@Autowired
	private GameRepository gameRepository;

	public List<Game> GetAllGames() {
		List<Game> games=new ArrayList<>();
		gameRepository.findAll().forEach(games::add);
		return games;
	}

	public List<Game> GetGamesbyid(int id) {
		List<Game> games=new ArrayList<>();
		gameRepository.findByCourseID(id).forEach(games::add);
		return games;
	}

	public void AddGame(Game game) {
		
		gameRepository.save(game);
	}

	public Game GetGame(int id) {
		return gameRepository.findOne(id);
	}

	public String GetGameName(int id) {
		Game temp=gameRepository.findOne(id);
		String N=temp.getName();
		return N;
	}

	public List<Game> GetNotMineGames(String email) {
		List<Game> allgames=new ArrayList<>();
		gameRepository.findAll().forEach(allgames::add);
		
		
		List<Game> mygames=new ArrayList<>();
		gameRepository.findByTeacherID(email).forEach(mygames::add);

		allgames.removeAll(mygames);

		return allgames;
	}

	public List<Game> GetGamesbyTeacherid(String email) {
		List<Game> games=new ArrayList<>();
		gameRepository.findByTeacherID(email).forEach(games::add);
		return games;
	}
	
}
