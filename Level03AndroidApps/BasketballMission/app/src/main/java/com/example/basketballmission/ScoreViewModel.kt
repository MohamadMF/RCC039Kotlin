package com.example.basketballmission

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ScoreViewModel : ViewModel() {
    //create the score number variable livedata and its default value
    var liveScoreTeamA = MutableLiveData(0)
    var liveScoreTeamB = MutableLiveData(0)

    // this is the watcher will be read-only the scored number to inform it to LifeCycle owner
    val observerTeamA : LiveData<Int> = liveScoreTeamA
    val observerTeamB : LiveData<Int> = liveScoreTeamB

    fun makeTeamAFreeThrow(){
        //method to make one by one increment to score value
        //set value             get setted value with safe call operation because it may unknown
        liveScoreTeamA.value = liveScoreTeamA.value?.plus(1)
    }
    fun makeTeamBFreeThrow() {
        //method to make one by one increment to score value
        //set value             get setted value with safe call operation because it may unknown
        liveScoreTeamB.value = liveScoreTeamB.value?.plus(1)
    }

    fun makeTeamADoublePoints(){
        //this method to make the increment by 2
        liveScoreTeamA.value = liveScoreTeamA.value?.plus(2)
    }

    fun makeTeamBDoublePoints(){
        //this method to make the increment by 2
        liveScoreTeamB.value = liveScoreTeamB.value?.plus(2)
    }

    fun makeTeamATriplePoints(){
        //this method to make the increment by 3
        liveScoreTeamA.value = liveScoreTeamA.value?.plus(3)
    }

    fun makeTeamBTriplePoints(){
        //this method to make the increment by 3
        liveScoreTeamB.value = liveScoreTeamB.value?.plus(3)
    }

    fun makeReset() {
        //method to reset the scored value to 0
        liveScoreTeamA.value = 0
        liveScoreTeamB.value = 0
    }
}