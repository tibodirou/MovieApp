import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Movie } from '../Models/movie';
import { MovieService } from '../Services/MovieService';


@Component({
  selector: 'app-movie-details',
  templateUrl: './movie-details.component.html',
  styleUrls: ['./movie-details.component.css']
})
export class MovieDetailsComponent implements OnInit {

  constructor(private route: ActivatedRoute,private router :Router,private movieService : MovieService) { }

  movie : Movie
  id : number
  ngOnInit(): void {
    
    const routeParams = this.route.snapshot.paramMap.get('id') as string;
    this.id = parseInt(routeParams);
    this.getMovieDetails();

  }

  public getMovieDetails(): void{
    this.movieService.getMovie(this.id).subscribe({
      next: (response : Movie) => {
        this.movie = response
        console.log(response.director)
      },
      error: (error : HttpErrorResponse) => {
        alert(error.message);
      }
    }
    )

  }
}
