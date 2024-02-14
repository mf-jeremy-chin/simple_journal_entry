package com.okeicalm.simpleJournalEntry.handler.mutation

import com.expediagroup.graphql.generator.scalars.ID
import com.expediagroup.graphql.server.operations.Mutation
import com.okeicalm.simpleJournalEntry.handler.type.AccountTagType
import com.okeicalm.simpleJournalEntry.usecase.account.AccountTagUpdateUseCase
import com.okeicalm.simpleJournalEntry.usecase.account.AccountTagUpdateUseCaseInput
import org.springframework.stereotype.Component

data class UpdateAccountTagInput(val id: ID, val name: String)

@Component
class UpdateAccountTagMutation(private val accountTagUpdateUseCase: AccountTagUpdateUseCase) : Mutation {
    fun updateAccountTag(input: UpdateAccountTagInput): AccountTagType {
        val output = accountTagUpdateUseCase.call(
            AccountTagUpdateUseCaseInput(
                id = input.id.toString().toLong(),
                name = input.name
            )
        )
        // this is the mutation, what do we do about not found?
        // updateAccount just..... doesn't care? It returns the input
        // which is dumb
        // letting the NPE move up here is differently dumb!
        return AccountTagType(ID(output.account!!.id.toString()), output.account.name, ID(output.account.account_id.toString()) )
    }
}
