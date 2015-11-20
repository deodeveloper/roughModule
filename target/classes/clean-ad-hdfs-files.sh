#!/bin/sh

#root path
rootPath='/ad'
suffix='20??/*/*/*/'

#process deduped-before-lookup
coordinatorNames='AdProviderAdGroupUpdate AdProviderKeywordUpdate AdCampaignUpdate'
basepaths='process deduped-before-lookup'

for coordinator in $coordinatorNames
do

    for basepath in $basepaths
    do
        hdfs dfs -rm -R -skipTrash $rootPath/$coordinator/$basepath/$suffix || echo unable to delete  $rootPath/$coordinator/$basepath/$suffix
    done

done

# duduped and process
coordinatorNames='AdCampaignConversionMetricsUpdate AdDisplayPlacementMetricsUpdate AdImpressionShareUpdate AdProviderMetricsUpdate AdMtdAccountMarkupRateUpdate ReportingGroupUpdate'
basepaths='deduped process'

for coordinator in $coordinatorNames
do

    for basepath in $basepaths
    do
        hdfs dfs -rm -R -skipTrash $rootPath/$coordinator/$basepath/$suffix || echo unable to delete  $rootPath/$coordinator/$basepath/$suffix
    done

done

#only deduped
coordinatorNames='AdCampaignUpdate AdProviderCreative'
for coordinator in $coordinatorNames
do
    hdfs dfs -rm -R -skipTrash $rootPath/$coordinator/deduped/$suffix || echo unable to delete  $rootPath/$coordinator/deduped/$suffix
done

#output ->ReportingGroup AdProviderMetrics
coordinatorNames='ReportingGroup AdProviderMetrics'
for coordinator in $coordinatorNames
do
    hdfs dfs -rm -R -skipTrash $rootPath/$coordinator/output/$suffix || echo unable to delete $rootPath/$coordinator/output/$suffix
done

#child ReportingGroup
hdfs dfs -rm -R -skipTrash $rootPath/ReportingGroup/output/child/$suffix || echo unable to delete $rootPath/ReportingGroup/output/child/$suffix

