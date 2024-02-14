package com.okeicalm.simpleJournalEntry.entity

import org.springframework.stereotype.Component

// jooq generated this as accounttag, that doesn't seem to make it any happier
data class AccountTag (
        val id: Long = 0,
        var name: String,
        val account_id: Long
)
