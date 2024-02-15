package com.okeicalm.simpleJournalEntry.handler.type

import com.expediagroup.graphql.generator.annotations.GraphQLName
import com.expediagroup.graphql.generator.scalars.ID
import com.okeicalm.simpleJournalEntry.entity.AccountTag

const val accountTagTypeGraphQLName = "AccountTag"

@GraphQLName(accountTagTypeGraphQLName)
data class AccountTagType(
        val id: ID,
        val name: String,
        val accountID: ID,
) {
    constructor(tag: AccountTag) : this(
        ID(tag.id.toString()),
        tag.name,
        ID(tag.account_id.toString())
    )
}
