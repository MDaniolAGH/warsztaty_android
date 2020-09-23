package com.example.warsztat_mvvm.models

//API zwraca nam tablice obiektow [{doctor1}, {doctor2}] zamiast tablicy obiektow zapakowanej w obiekt, jak bylo poprzednio: {staffMembers:[{doctor1},{doctor2}]},
//dlatego trzeba bylo przerobic nasz kod, aby zwracal List<StaffMember> (np. widoczne w MedicalListService czy MainActivityViewModel)
//Zmienila sie takze struktura danych, age i price są teraz Int zamiast String. Kod musiał zostać zaadoptowany do tego. 

data class StaffMember(
    val name: String?,
    val age: Int,
    val specialization: String?,
    val price: Int,
    val availability: Boolean?
)