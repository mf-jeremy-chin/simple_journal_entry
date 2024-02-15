package com.okeicalm.simpleJournalEntry.entity

import org.springframework.stereotype.Component

data class AccountTag (
        val id: Long = 0,
        var name: String,
        val account_id: Long
)
