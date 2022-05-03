

INSERT INTO genres (Name) 
VALUES ('Rap Folk');



INSERT INTO artists (Name)
VALUES ('Folk Vibes');



INSERT INTO albums (Title, ArtistId)
VALUES ('Out there behind the forest', 26);



INSERT INTO tracks (Name, AlbumId, MediaTypeId, Milliseconds, UnitPrice, GenreId)
VALUES ('Red Poppies', (SELECT AlbumId FROM albums WHERE Title = 'Out there behind the forest'), 1, 120895, 0.86, 27),
('Blue-eyed', (SELECT AlbumId FROM albums WHERE Title = 'Out there behind the forest'), 1, 129330, 0.86, 27);



UPDATE tracks 
SET GenreId = (SELECT GenreId FROM genres WHERE Name = 'Opera')
WHERE Name = 'Red Poppies';

DELETE FROM tracks 
WHERE Name = 'Red Poppies';

SELECT t.Name Song, 
a.Title Album, 
a.Title Artist, 
g.Name Genre,
t.Milliseconds ,
t.MediaTypeId ,
t.UnitPrice 
FROM tracks t
JOIN genres g 
ON t.GenreId = g.GenreId 
JOIN albums a 
ON t.AlbumId = a.AlbumId 
JOIN artists a2 
ON a.ArtistId = a2.ArtistId 
WHERE t.Name = 'Blue-eyed';
