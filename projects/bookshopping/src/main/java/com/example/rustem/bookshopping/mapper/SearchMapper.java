package com.example.rustem.bookshopping.mapper;

import com.example.rustem.bookshopping.dto.SearchDto;
import com.example.rustem.bookshopping.entity.Search;

public class SearchMapper {

	public static Search mapToSearch(SearchDto searchDto) {
		Search search = new Search(
				searchDto.getSearch(),
				searchDto.getBegin(),
				searchDto.getLength()
				);
		return search;
	}
	
	public static SearchDto mapToSearchDto(Search search) {
		SearchDto searchDto = new SearchDto(
				search.getSearch(),
				search.getBegin(),
				search.getLength()
				);
		return searchDto;
	}
}
