package com.example.emergencyexercise.data

import com.example.emergencyexercise.R
import com.example.emergencyexercise.model.Contacts

class EmergencyContacts {
    fun loadContactsArray() : MutableList<Contacts> {
        return mutableListOf(
            Contacts(R.string.name01,R.string.num01),
            Contacts(R.string.name02,R.string.num02),
            Contacts(R.string.name03,R.string.num03),
            Contacts(R.string.name04,R.string.num04),
            Contacts(R.string.name05,R.string.num05),
            Contacts(R.string.name06,R.string.num06),
            Contacts(R.string.name07,R.string.num07),
            Contacts(R.string.name08,R.string.num08),
            Contacts(R.string.name09,R.string.num09),
            Contacts(R.string.name10,R.string.num10),
            Contacts(R.string.name11,R.string.num11),
            Contacts(R.string.name12,R.string.num12),
            Contacts(R.string.name13,R.string.num13),
            Contacts(R.string.name14,R.string.num14),
            Contacts(R.string.name15,R.string.num15),
            Contacts(R.string.name16,R.string.num16),
            Contacts(R.string.name17,R.string.num17),
            Contacts(R.string.name18,R.string.num18),)
    }
}