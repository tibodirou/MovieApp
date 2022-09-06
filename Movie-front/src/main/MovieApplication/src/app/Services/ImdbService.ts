import { HttpClient } from "@angular/common/http";
import { Inject, Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { environment } from "src/environments/environment";
import { Movie } from "../Models/movie";

@Injectable({providedIn: 'root'})
export class ImdbService {
    private apikey = environment.apikey
    constructor(private http: HttpClient){}

    public getImage(id: number,imagepath :string ): Observable<string> {
        return this.http.get(`https://image.tmdb.org/t/p/w${id}${imagepath}`,{responseType: 'text'});
    }

    public getMovie(id: number): Observable<string> {
        return this.http.get<string>(`https://api.themoviedb.org/3/movie/${id}?api_key=${this.apikey}`);
    }

    public getMovieByName(name: string): Observable<string> {
        return this.http.get<string>(`https://api.themoviedb.org/3/search/movie?api_key=${this.apikey}&query=${name}`);
    }
}

//finir ajout de livres