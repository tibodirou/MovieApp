import { HttpClient } from "@angular/common/http";
import { Inject, Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { environment } from "src/environments/environment";
import { Movie } from "../Models/movie";

@Injectable({providedIn: 'root'})
export class MovieService {
    private apiServerUrl = environment.apiBaseUrl;
    private apikey = environment.apikey
    constructor(private http: HttpClient){}

    public getMovies(): Observable<string[]> {
        return this.http.get<string[]>(`${this.apiServerUrl}/Movie/api/movies`);
    }


    public getMovie(id: number): Observable<Movie>  {
        return this.http.get<Movie>(`${this.apiServerUrl}/Movie/api/movie/${id}`);
    }

    public fillDB(movies : Movie[]): Observable<Movie[]>{
        return this.http.post<Movie[]>(`${this.apiServerUrl}/Movie/api/fill`,movies);
    }

    public test(id: number): Observable<string>  {
        return this.http.get<string>(`${this.apiServerUrl}/Movie/api/movie/tgt`);
    }
}
