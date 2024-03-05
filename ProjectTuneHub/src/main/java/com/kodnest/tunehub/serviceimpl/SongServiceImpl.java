package com.kodnest.tunehub.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodnest.tunehub.entity.Song;
import com.kodnest.tunehub.repository.SongRepository;
import com.kodnest.tunehub.service.SongService;

@Service
public class SongServiceImpl implements SongService{
	@Autowired
	SongRepository songRepository;
	
	@Override
	public String addSong(Song song) {
		songRepository.save(song);
		return "song Added";
		
	}
	public boolean nameExists(String name) {
		if(songRepository.findByName(name)!=null) {
			return true;
		}else {
			return false;
		}
	}
	@Override
	public List<Song> fetchAllSongs(){
		List<Song> songs=songRepository.findAll();
		return songs;
		
	}
	@Override
	public void updateSong(Song s) {
		songRepository.save(s);
		
	}

}
