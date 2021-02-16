package com.parth.MoviesCatalog.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.parth.MoviesCatalog.models.CatalogItem;

@RestController
@RequestMapping("/catalog")
public class MoviesCatalogResource {

	@RequestMapping("/getCatalogList/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
		List<CatalogItem> catalogItemList = new ArrayList<CatalogItem>();
		catalogItemList.add(new CatalogItem("transformers", "test", 5));
		return catalogItemList;
	}
}
