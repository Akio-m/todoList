package com.app.akio.todolist

import android.text.format.DateFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import io.realm.OrderedRealmCollection
import io.realm.RealmBaseAdapter
import java.text.FieldPosition

class TodoAdapter(data: OrderedRealmCollection<Todo>?) : RealmBaseAdapter<Todo>(data) {

    inner class ViewHolder(cell: View) {
        val date = cell.findViewById<TextView>(android.R.id.text1)
        val title = cell.findViewById<TextView>(android.R.id.text2)
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val viewHolder: ViewHolder

        when (convertView) {
            null -> {
                val inflater = LayoutInflater.from(parent?.context)
                view = inflater.inflate(android.R.layout.simple_list_item_2, parent, false)
                viewHolder = ViewHolder(view)
                view.tag = viewHolder
            }
            else -> {
                view = convertView
                viewHolder = view.tag as ViewHolder
            }
        }

        adapterData?.run {
            val todo = get(position)
            viewHolder.date.text = DateFormat.format("yyyy/MM/dd", todo.date)
            viewHolder.title.text = todo.title
        }

        return view
    }

}