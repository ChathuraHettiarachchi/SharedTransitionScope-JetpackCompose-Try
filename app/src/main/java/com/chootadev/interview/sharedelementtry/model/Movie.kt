package com.chootadev.interview.sharedelementtry.model

import org.json.JSONArray

data class Movie(
    val backdropPath: String,
    val posterPath: String,
    val title: String,
    val overview: String,
    val voteAverage: Double,
    val voteCount: Int,
    val id: Int
)

fun List<Movie>.find(id:Int): Movie {
    return this.findLast{
        it.id == id
    }!!
}

fun MovieList(): List<Movie> {
    val jsonData = """[
        {
      "adult": false,
      "backdrop_path": "/xOMo8BRK7PfcJv9JCnx7s5hj0PX.jpg",
      "genre_ids": [
        878,
        12
      ],
      "id": 693134,
      "original_language": "en",
      "original_title": "Dune: Part Two",
      "overview": "Follow the mythic journey of Paul Atreides as he unites with Chani and the Fremen while on a path of revenge against the conspirators who destroyed his family. Facing a choice between the love of his life and the fate of the known universe, Paul endeavors to prevent a terrible future only he can foresee.",
      "popularity": 2938.734,
      "poster_path": "/1pdfLvkbY9ohJlCjQH2CZjjYVvJ.jpg",
      "release_date": "2024-02-27",
      "title": "Dune: Part Two",
      "video": false,
      "vote_average": 8.298,
      "vote_count": 2992
    },
    {
      "adult": false,
      "backdrop_path": "/1XDDXPXGiI8id7MrUxK36ke7gkX.jpg",
      "genre_ids": [
        16,
        28,
        10751,
        35,
        14
      ],
      "id": 1011985,
      "original_language": "en",
      "original_title": "Kung Fu Panda 4",
      "overview": "Po is gearing up to become the spiritual leader of his Valley of Peace, but also needs someone to take his place as Dragon Warrior. As such, he will train a new kung fu practitioner for the spot and will encounter a villain called the Chameleon who conjures villains from the past.",
      "popularity": 2043.817,
      "poster_path": "/kDp1vUBnMpe8ak4rjgl3cLELqjU.jpg",
      "release_date": "2024-03-02",
      "title": "Kung Fu Panda 4",
      "video": false,
      "vote_average": 7.156,
      "vote_count": 1090
    },
    {
      "adult": false,
      "backdrop_path": "/j3Z3XktmWB1VhsS8iXNcrR86PXi.jpg",
      "genre_ids": [
        28,
        878,
        12,
        14
      ],
      "id": 823464,
      "original_language": "en",
      "original_title": "Godzilla x Kong: The New Empire",
      "overview": "Following their explosive showdown, Godzilla and Kong must reunite against a colossal undiscovered threat hidden within our world, challenging their very existence – and our own.",
      "popularity": 1851.749,
      "poster_path": "/tMefBSflR6PGQLv7WvFPpKLZkyk.jpg",
      "release_date": "2024-03-27",
      "title": "Godzilla x Kong: The New Empire",
      "video": false,
      "vote_average": 6.7,
      "vote_count": 652
    },
    {
      "adult": false,
      "backdrop_path": "/qekky2LbtT1wtbD5MDgQvjfZQ24.jpg",
      "genre_ids": [
        28,
        53
      ],
      "id": 984324,
      "original_language": "fr",
      "original_title": "Le salaire de la peur",
      "overview": "When an explosion at an oil well threatens hundreds of lives, a crack team is called upon to make a deadly desert crossing with nitroglycerine in tow.",
      "popularity": 768.564,
      "poster_path": "/jFK2ZLQUzo9pea0jfMCHDfvWsx7.jpg",
      "release_date": "2024-03-28",
      "title": "The Wages of Fear",
      "video": false,
      "vote_average": 5.817,
      "vote_count": 164
    },
    {
      "adult": false,
      "backdrop_path": "/pwGmXVKUgKN13psUjlhC9zBcq1o.jpg",
      "genre_ids": [
        28,
        14
      ],
      "id": 634492,
      "original_language": "en",
      "original_title": "Madame Web",
      "overview": "Forced to confront revelations about her past, paramedic Cassandra Webb forges a relationship with three young women destined for powerful futures...if they can all survive a deadly present.",
      "popularity": 720.203,
      "poster_path": "/rULWuutDcN5NvtiZi4FRPzRYWSh.jpg",
      "release_date": "2024-02-14",
      "title": "Madame Web",
      "video": false,
      "vote_average": 5.652,
      "vote_count": 1087
    },
    {
      "adult": false,
      "backdrop_path": "/2KGxQFV9Wp1MshPBf8BuqWUgVAz.jpg",
      "genre_ids": [
        16,
        28,
        12,
        35,
        10751
      ],
      "id": 940551,
      "original_language": "en",
      "original_title": "Migration",
      "overview": "After a migrating duck family alights on their pond with thrilling tales of far-flung places, the Mallard family embarks on a family road trip, from New England, to New York City, to tropical Jamaica.",
      "popularity": 662.017,
      "poster_path": "/ldfCF9RhR40mppkzmftxapaHeTo.jpg",
      "release_date": "2023-12-06",
      "title": "Migration",
      "video": false,
      "vote_average": 7.531,
      "vote_count": 1181
    },
    {
      "adult": false,
      "backdrop_path": "/lzWHmYdfeFiMIY4JaMmtR7GEli3.jpg",
      "genre_ids": [
        878,
        12
      ],
      "id": 438631,
      "original_language": "en",
      "original_title": "Dune",
      "overview": "Paul Atreides, a brilliant and gifted young man born into a great destiny beyond his understanding, must travel to the most dangerous planet in the universe to ensure the future of his family and his people. As malevolent forces explode into conflict over the planet's exclusive supply of the most precious resource in existence-a commodity capable of unlocking humanity's greatest potential-only those who can conquer their fear will survive.",
      "popularity": 617.634,
      "poster_path": "/d5NXSklXo0qyIYkgV94XAgMIckC.jpg",
      "release_date": "2021-09-15",
      "title": "Dune",
      "video": false,
      "vote_average": 7.789,
      "vote_count": 11293
    },
    {
      "adult": false,
      "backdrop_path": "/9wJO4MBzkqgUZemLTGEsgUbYyP6.jpg",
      "genre_ids": [
        878,
        9648,
        53,
        28
      ],
      "id": 720321,
      "original_language": "en",
      "original_title": "Breathe",
      "overview": "Air-supply is scarce in the near future, forcing a mother and daughter to fight for survival when two strangers arrive desperate for an oxygenated haven.",
      "popularity": 602.7,
      "poster_path": "/wTW2t8ocWDlHns8I7vQxuqkyK58.jpg",
      "release_date": "2024-04-04",
      "title": "Breathe",
      "video": false,
      "vote_average": 5.288,
      "vote_count": 33
    },
    {
      "adult": false,
      "backdrop_path": "/cIztAxDn3H8JylRaJwiHHpkGe53.jpg",
      "genre_ids": [
        10751,
        35,
        16
      ],
      "id": 1239146,
      "original_language": "en",
      "original_title": "Woody Woodpecker Goes to Camp",
      "overview": "After getting kicked out of the forest, Woody thinks he's found a forever home at Camp Woo Hoo — until an inspector threatens to shut down the camp.",
      "popularity": 584.521,
      "poster_path": "/8BYT4D0E0f1qFb9WfJPH4YUirL.jpg",
      "release_date": "2024-04-12",
      "title": "Woody Woodpecker Goes to Camp",
      "video": false,
      "vote_average": 7.29,
      "vote_count": 50
    },
    {
      "adult": false,
      "backdrop_path": "/e3gVl1gnxEFKLTF6pn6KRqUPi9K.jpg",
      "genre_ids": [
        10749,
        18
      ],
      "id": 1127166,
      "original_language": "it",
      "original_title": "Fabbricante di lacrime",
      "overview": "Adopted together after a tough childhood in an orphanage, Nica and Rigel realize that unexpected but irresistible feelings pull them together.",
      "popularity": 583.465,
      "poster_path": "/uoBHsxSgfc3PQsSn98RfnbePHOy.jpg",
      "release_date": "2024-04-03",
      "title": "The Tearsmith",
      "video": false,
      "vote_average": 6.672,
      "vote_count": 358
    },
    {
      "adult": false,
      "backdrop_path": "/uv2twFGMk2qBdyJBJAVcrpRtSa9.jpg",
      "genre_ids": [
        28,
        10752,
        878
      ],
      "id": 929590,
      "original_language": "en",
      "original_title": "Civil War",
      "overview": "In the near future, a group of war journalists attempt to survive while reporting the truth as the United States stands on the brink of civil war.",
      "popularity": 532.705,
      "poster_path": "/sh7Rg8Er3tFcN9BpKIPOMvALgZd.jpg",
      "release_date": "2024-04-10",
      "title": "Civil War",
      "video": false,
      "vote_average": 7.432,
      "vote_count": 111
    },
    {
      "adult": false,
      "backdrop_path": "/wUp0bUXaveR40ikBhDgWwNTijuD.jpg",
      "genre_ids": [
        28,
        9648,
        53
      ],
      "id": 1181548,
      "original_language": "en",
      "original_title": "Heart of the Hunter",
      "overview": "A retired assassin is pulled back into action when his friend uncovers a dangerous conspiracy at the heart of the South African government.",
      "popularity": 510.92,
      "poster_path": "/n726fdyL1dGwt15bY7Nj3XOXc4Q.jpg",
      "release_date": "2024-03-28",
      "title": "Heart of the Hunter",
      "video": false,
      "vote_average": 5.894,
      "vote_count": 66
    },
    {
      "adult": false,
      "backdrop_path": "/b4xaqpUZFUkgyJ1VcFEPXmDML34.jpg",
      "genre_ids": [
        27,
        53
      ],
      "id": 845783,
      "original_language": "en",
      "original_title": "Baghead",
      "overview": "Following the death of her estranged father, Iris learns she has inherited a run-down, centuries-old pub. She travels to Berlin to identify her father’s body and meet with The Solicitor to discuss the estate. Little does she know, when the deed is signed she will become inextricably tied to an unspeakable entity that resides in the pub’s basement – Baghead – a shape-shifting creature that can transform into the dead.",
      "popularity": 459.133,
      "poster_path": "/lbOyeiiRYAE6Nm2e7xiNAAaRwZB.jpg",
      "release_date": "2023-12-28",
      "title": "Baghead",
      "video": false,
      "vote_average": 6.78,
      "vote_count": 116
    },
    {
      "adult": false,
      "backdrop_path": "/5cCfqeUH2f5Gnu7Lh9xepY9TB6x.jpg",
      "genre_ids": [
        14,
        12,
        35
      ],
      "id": 967847,
      "original_language": "en",
      "original_title": "Ghostbusters: Frozen Empire",
      "overview": "The Spengler family returns to where it all started – the iconic New York City firehouse – to team up with the original Ghostbusters, who've developed a top-secret research lab to take busting ghosts to the next level. But when the discovery of an ancient artifact unleashes an evil force, Ghostbusters new and old must join forces to protect their home and save the world from a second Ice Age.",
      "popularity": 447.565,
      "poster_path": "/6faYaQyiBPhqAizldJKq21mIVaE.jpg",
      "release_date": "2024-03-20",
      "title": "Ghostbusters: Frozen Empire",
      "video": false,
      "vote_average": 6.5,
      "vote_count": 249
    },
    {
      "adult": false,
      "backdrop_path": "/4woSOUD0equAYzvwhWBHIJDCM88.jpg",
      "genre_ids": [
        28,
        27,
        53
      ],
      "id": 1096197,
      "original_language": "en",
      "original_title": "No Way Up",
      "overview": "Characters from different backgrounds are thrown together when the plane they're travelling on crashes into the Pacific Ocean. A nightmare fight for survival ensues with the air supply running out and dangers creeping in from all sides.",
      "popularity": 434.011,
      "poster_path": "/hu40Uxp9WtpL34jv3zyWLb5zEVY.jpg",
      "release_date": "2024-01-18",
      "title": "No Way Up",
      "video": false,
      "vote_average": 6.334,
      "vote_count": 380
    },
    {
      "adult": false,
      "backdrop_path": "/nb3xI8XI3w4pMVZ38VijbsyBqP4.jpg",
      "genre_ids": [
        18,
        36
      ],
      "id": 872585,
      "original_language": "en",
      "original_title": "Oppenheimer",
      "overview": "The story of J. Robert Oppenheimer's role in the development of the atomic bomb during World War II.",
      "popularity": 431.357,
      "poster_path": "/8Gxv8gSFCU0XGDykEGv7zR1n2ua.jpg",
      "release_date": "2023-07-19",
      "title": "Oppenheimer",
      "video": false,
      "vote_average": 8.11,
      "vote_count": 7681
    },
    {
      "adult": false,
      "backdrop_path": "/TGsfNWkASegCfAn6ED1b08a9O6.jpg",
      "genre_ids": [
        27,
        9648,
        53
      ],
      "id": 1125311,
      "original_language": "en",
      "original_title": "Imaginary",
      "overview": "When Jessica moves back into her childhood home with her family, her youngest stepdaughter Alice develops an eerie attachment to a stuffed bear named Chauncey she finds in the basement. Alice starts playing games with Chauncey that begin playful and become increasingly sinister. As Alice’s behavior becomes more and more concerning, Jessica intervenes only to realize Chauncey is much more than the stuffed toy bear she believed him to be.",
      "popularity": 393.873,
      "poster_path": "/9u6HEtZJdZDjPGGJq6YEuhPnoan.jpg",
      "release_date": "2024-03-06",
      "title": "Imaginary",
      "video": false,
      "vote_average": 6.252,
      "vote_count": 220
    },
    {
      "adult": false,
      "backdrop_path": "/mIBG74mhGEJnBubhYLkCtvplcNr.jpg",
      "genre_ids": [
        27
      ],
      "id": 437342,
      "original_language": "en",
      "original_title": "The First Omen",
      "overview": "When a young American woman is sent to Rome to begin a life of service to the church, she encounters a darkness that causes her to question her own faith and uncovers a terrifying conspiracy that hopes to bring about the birth of evil incarnate.",
      "popularity": 364.92,
      "poster_path": "/hil2ResSCwP95JweZVJsZ5CbZdc.jpg",
      "release_date": "2024-04-03",
      "title": "The First Omen",
      "video": false,
      "vote_average": 6.698,
      "vote_count": 101
    },
    {
      "adult": false,
      "backdrop_path": "/oBIQDKcqNxKckjugtmzpIIOgoc4.jpg",
      "genre_ids": [
        28,
        53,
        10752
      ],
      "id": 969492,
      "original_language": "en",
      "original_title": "Land of Bad",
      "overview": "When a Delta Force special ops mission goes terribly wrong, Air Force drone pilot Reaper has 48 hours to remedy what has devolved into a wild rescue operation. With no weapons and no communication other than the drone above, the ground mission suddenly becomes a full-scale battle when the team is discovered by the enemy.",
      "popularity": 357.438,
      "poster_path": "/h3jYanWMEJq6JJsCopy1h7cT2Hs.jpg",
      "release_date": "2024-01-25",
      "title": "Land of Bad",
      "video": false,
      "vote_average": 7.193,
      "vote_count": 567
    },
    {
      "adult": false,
      "backdrop_path": "/ugnzz1A9mjJUgnFwVqEUsUNt7t6.jpg",
      "genre_ids": [
        10749,
        35
      ],
      "id": 1005681,
      "original_language": "es",
      "original_title": "Pared con pared",
      "overview": "She’s a young pianist preparing for an audition. He is a games inventor who can only concentrate in complete silence. Separated by only a paper-thin wall in conjoined apartments, will they learn to live in harmony with one another? Will romance blossom through the wall?",
      "popularity": 284.047,
      "poster_path": "/zvrkAXaFFPpJCFcus18qlsGfOrz.jpg",
      "release_date": "2024-04-12",
      "title": "Love, Divided",
      "video": false,
      "vote_average": 6.525,
      "vote_count": 59
    }
    ]"""

    val movies = mutableListOf<Movie>()
    val jsonArray = JSONArray(jsonData)
    for (i in 0 until jsonArray.length()) {
        val movieJson = jsonArray.getJSONObject(i)
        movies.add(
            Movie(
                movieJson.optString("backdrop_path", ""),
                movieJson.optString("poster_path", ""),
                movieJson.getString("title"),
                movieJson.getString("overview"),
                movieJson.getDouble("vote_average"),
                movieJson.getInt("vote_count"),
                movieJson.getInt("id"),
            )
        )
    }
    return movies
}
