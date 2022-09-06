import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit} from '@angular/core';
import { Router } from '@angular/router';
import { Movie } from '../Models/movie';
import { ImdbService } from '../Services/ImdbService';
import { MovieService } from '../Services/MovieService';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {


  constructor(private movieService : MovieService, private imbdService : ImdbService, private router :Router ) {}

  public genre : string[] = []
  public movies : Movie[] = [];

  ngOnInit(): void {
    this.getMoviesFromDisk();
  }

  public fillDB(): void {
    this.movieService.fillDB(this.movies).subscribe({
      next: (response : Movie[]) => {   
        console.log(response)
      },
      error: (error : HttpErrorResponse) => {
        alert(error.message);
      }
    }
    )
  }

  public test(): void {
    this.movieService.test(this.movies[0].id).subscribe({
      next: (response : string) => {   
        console.log(response)
      },
      error: (error : HttpErrorResponse) => {
        alert(error.message);
      }
    }
    )
  }


  public getMoviesFromDisk(): void{
    this.movieService.getMovies().subscribe({
      next: (response : string[]) => {
        for(let key in response){
          let movie = response[key]
          this.getMovieByName(movie)
        }
      },
      error: (error : HttpErrorResponse) => {
        alert(error.message);
      }
    }
    )

  }
  /*
  public getMovie(): void{
    this.imbdService.getMovie(Math.floor(Math.random() * 500)).subscribe({
      next: (response : string) => {
        this.MovieDetails = response
        this.genre = []
        for (let key in this.MovieDetails['genres']){
          let value = this.MovieDetails['genres'][key]['name'];
          this.genre.push(value)
        }
        this.img = `https://image.tmdb.org/t/p/w500${this.MovieDetails["poster_path"]}`
        this.score = Math.round(this.MovieDetails['vote_average']/2 * 10) / 10
      },
      error: (error : HttpErrorResponse) => {
        alert(error.message);
      }
    }
    )
  }
*/
  public getMovieByName(movie : string): void{
    this.imbdService.getMovieByName(movie).subscribe({
      next: (response : string) => {

        response = response['results'][0]
        var newMovie: Movie = {
          
          id : response['id'],
          title : movie,
          score : Math.round(response['vote_average']/2 * 10) / 10,
          summary: response['overview'],
          language :response['original_language'],
          thumbnail : `https://image.tmdb.org/t/p/w500${response["poster_path"]}`,
          director : "Thibo",
          genres:[],
          subtitle:"thibo"
      }
        this.getMovieComplementaryInfo(newMovie)
      },
      error: (error : HttpErrorResponse) => {
        alert(error.message);
      }
    }
    )

  }


  public getMovieComplementaryInfo(movie : Movie): void{
    this.imbdService.getMovie(movie.id).subscribe({
      next: (response : string) => {
        for(let key in response['genres']){
          movie.genres.push(response['genres'][key]["name"])
        }
        this.movies.push(movie)
      },
      error: (error : HttpErrorResponse) => {
        alert(error.message);
      }
    }
    )

  }


  public goToMovieDetails(id : number): void {
    this.router.navigate(['/movie-details', id]);
  }


}


